package com.business.cybord.config.properties;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ConfigurationProperties(prefix = "invoicedatasource")
//public class DataBaseConfig implements Serializable{
//
//	private static final long serialVersionUID = 8914903583724311162L;
//
//	@Value("${cajadatasource.springDatasourceUsername}")
//	private String dataSourceUser;
//
//	@Value("${cajadatasource.springDatasourcePassword}")
//	private String dataSourcePass;
//
//	@Value("${cajadatasource.springDatasourceDriverClassName}")
//	private String dataSourceClassName;
//
//	@Value("${cajadatasource.springDatasourceUrl}")
//	private String dataSourceUrl;
//
//	public String getDataSourceUser() {
//		return dataSourceUser;
//	}
//
//	public void setDataSourceUser(String dataSourceUser) {
//		this.dataSourceUser = dataSourceUser;
//	}
//
//	public String getDataSourcePass() {
//		return dataSourcePass;
//	}
//
//	public void setDataSourcePass(String dataSourcePass) {
//		this.dataSourcePass = dataSourcePass;
//	}
//
//	public String getDataSourceClassName() {
//		return dataSourceClassName;
//	}
//
//	public void setDataSourceClassName(String dataSourceClassName) {
//		this.dataSourceClassName = dataSourceClassName;
//	}
//
//	public String getDataSourceUrl() {
//		return dataSourceUrl;
//	}
//
//	public void setDataSourceUrl(String dataSourceUrl) {
//		this.dataSourceUrl = dataSourceUrl;
//	}
//
//	@Override
//	public String toString() {
//		return "InvoiceConfig [dataSourceUser=" + dataSourceUser + ", dataSourcePass=" + dataSourcePass
//				+ ", dataSourceClassName=" + dataSourceClassName + ", dataSourceUrl=" + dataSourceUrl + "]";
//	}
//}
