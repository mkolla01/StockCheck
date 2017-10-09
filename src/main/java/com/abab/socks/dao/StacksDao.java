package com.abab.socks.dao;

import java.util.concurrent.TimeUnit;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.QueryOptions;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.policies.ConstantReconnectionPolicy;
import com.datastax.driver.core.policies.DCAwareRoundRobinPolicy;
import com.datastax.driver.core.policies.DefaultRetryPolicy;
import com.datastax.driver.core.policies.LoggingRetryPolicy;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;

public class StacksDao {

	public Cluster  createCluster (Cluster cluster) throws Exception {
		
	
	try{
		QueryOptions qOptions = new QueryOptions().setConsistencyLevel(ConsistencyLevel.LOCAL_QUORUM);
	
		 cluster = Cluster.builder()
	        .addContactPoint("35.202.155.87")
	        .withCredentials("cassandra", "cassandra")
	        .withQueryOptions(qOptions)
	        .withRetryPolicy(new LoggingRetryPolicy(DefaultRetryPolicy.INSTANCE))
	        .withReconnectionPolicy(new ConstantReconnectionPolicy(TimeUnit.SECONDS.toMillis(5))).build();
	        // something   	 
		} catch(Exception e) { 
			//System.out.println("Caught exception while creating cluster"+e);
			throw e;
		}
	return cluster;
	}
	
	public void selectAccess() throws Exception{
		Cluster cluster = null;
		Session session = null;
		try{
		cluster = createCluster ( cluster); 
		
		//Session session = null;
			
		session = cluster.connect("system");
		String sql = "select data_center from system.peers";
		Row rs = session.execute(sql).one();
		
		if ( rs != null){
			
			System.out.println(rs.getString("data_center"));
		}
		
		}catch (Exception e){ 
			//System.out.println("Caught exception while creating cluster"+e);
			throw e;
		}
		finally{ 
			session.close();
			cluster.close();
		}
		
			
	
	}
	public static void main(String args[]){
		StacksDao stacksDao = new StacksDao();
		try{
			
			stacksDao.selectAccess();
		} catch(Exception e){
			System.out.println("Caught exception while creating cluster"+e);
		}
		
		
	}
}