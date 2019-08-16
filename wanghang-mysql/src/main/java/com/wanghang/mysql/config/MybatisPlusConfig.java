package com.wanghang.mysql.config;


import com.baomidou.mybatisplus.MybatisConfiguration;
import com.baomidou.mybatisplus.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import javax.sql.DataSource;

import com.wanghang.mysql.common.enmuns.DelEnum;
import com.wanghang.mysql.db.MyMetaObjectHandler;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;



@Configuration
@EnableTransactionManagement
@AutoConfigureAfter({DataSourceConfig.class})
public class MybatisPlusConfig implements TransactionManagementConfigurer{
		private Logger logger = LoggerFactory.getLogger(MybatisPlusConfig.class);

		@Autowired
		@Qualifier("primaryDataSource")
		private DataSource dataSource;

		@Bean
		public PaginationInterceptor paginationInterceptor(){
			this.logger.info("$$$ init PaginationInterceptor");

			PaginationInterceptor interceptor = new PaginationInterceptor();
			interceptor.setDialectType(DBType.MYSQL.getDb());
			return interceptor;
		}

		@Bean
		public SqlSessionFactory sqlSessionFactory(){
			this.logger.info("$$$ init sqlSessionFactory");
			MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();
			mybatisPlus.setDataSource(this.dataSource);
			mybatisPlus.setTypeAliasesPackage("com.wanghang.mysql.**.entity");
			mybatisPlus.setPlugins(new Interceptor[] { paginationInterceptor() });
			mybatisPlus.setVfs(SpringBootVFS.class);

			GlobalConfiguration globalConfig = new GlobalConfiguration();
			globalConfig.setDbType(DBType.MYSQL.getDb());
			globalConfig.setDbColumnUnderline(true);
			globalConfig.setCapitalMode(true);

			globalConfig.setIdType(3);
			globalConfig.setRefresh(false);

			globalConfig.setSqlInjector(new LogicSqlInjector());
			globalConfig.setLogicDeleteValue("" + DelEnum.NO_VALID.getType());
			globalConfig.setLogicNotDeleteValue("" + DelEnum.VALID.getType());

			globalConfig.setMetaObjectHandler(new MyMetaObjectHandler());
			mybatisPlus.setGlobalConfig(globalConfig);

			MybatisConfiguration config = new MybatisConfiguration();

			config.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
			config.setVfsImpl(SpringBootVFS.class);

			config.setMapUnderscoreToCamelCase(true);
			config.setCacheEnabled(true);

			config.setLogImpl(StdOutImpl.class);
			mybatisPlus.setConfiguration(config);
			try{
				ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
				Resource[] resources = resolver.getResources("classpath*:mapper/**/*Mapper.xml");
				mybatisPlus.setMapperLocations(resources);

				this.logger.info("$$$ quit sqlSessionFactory");
				return mybatisPlus.getObject();
			}catch (Exception e){
				throw new RuntimeException("sqlSessionFactory init fail", e);
			}
		}
		@Bean
		public PlatformTransactionManager annotationDrivenTransactionManager(){
			return new DataSourceTransactionManager(this.dataSource);
		}
}
