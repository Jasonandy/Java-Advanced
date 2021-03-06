/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018. JasonInternational.</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.fastdfs;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;

/**
* @Package：cn.ucaner.fastdfs   
* @ClassName：FastdfsClientConfig   
* @Description：   <p> FastdfsClientConfig</p>
* @Author： - Jason   
* @CreatTime：2018年3月14日 上午10:34:14   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public class FastdfsClientConfig {
	
	public static final int DEFAULT_CONNECT_TIMEOUT = 5; // second  默认的连接超时时间
	public static final int DEFAULT_NETWORK_TIMEOUT = 30; // second 默认的网络超时时间
	
	private int connectTimeout = DEFAULT_CONNECT_TIMEOUT * 1000;
	private int networkTimeout = DEFAULT_NETWORK_TIMEOUT * 1000;
	private List<String> trackerAddrs = new ArrayList<String>();
//	private int trackerClientPoolMaxIdlePerKey = 
	
	public FastdfsClientConfig() {
		super();
	}
	
	public FastdfsClientConfig(String configFile) throws ConfigurationException {
		super();
//		String conf = FastdfsClientConfig.class.getClassLoader().getResource(configFile).getPath();
		Configuration config = new PropertiesConfiguration(configFile);
		this.connectTimeout = config.getInt("connect_timeout", DEFAULT_CONNECT_TIMEOUT)*1000;
		this.networkTimeout = config.getInt("network_timeout", DEFAULT_NETWORK_TIMEOUT)*1000;
		List<Object> trackerServers = config.getList("tracker_server");
		for(Object trackerServer:trackerServers){
			trackerAddrs.add((String)trackerServer);
		}
	}
	
	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getNetworkTimeout() {
		return networkTimeout;
	}

	public void setNetworkTimeout(int networkTimeout) {
		this.networkTimeout = networkTimeout;
	}

	public List<String> getTrackerAddrs() {
		return trackerAddrs;
	}

	public void setTrackerAddrs(List<String> trackerAddrs) {
		this.trackerAddrs = trackerAddrs;
	}

	public GenericKeyedObjectPoolConfig getTrackerClientPoolConfig(){
		GenericKeyedObjectPoolConfig poolConfig = new GenericKeyedObjectPoolConfig();
//		poolConfig.setMaxIdlePerKey(maxIdlePerKey);
//		poolConfig.setMaxTotal(maxTotal);
//		poolConfig.setMaxTotalPerKey(maxTotalPerKey);
//		poolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//		poolConfig.setma
		
		return poolConfig;
	}
	

	public GenericKeyedObjectPoolConfig getStorageClientPoolConfig(){
		GenericKeyedObjectPoolConfig poolConfig = new GenericKeyedObjectPoolConfig();
		return poolConfig;
	}

}
