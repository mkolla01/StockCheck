package com.abab.socks.dao;

import java.util.concurrent.TimeUnit;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.QueryOptions;
import com.datastax.driver.core.policies.ConstantReconnectionPolicy;
import com.datastax.driver.core.policies.DCAwareRoundRobinPolicy;
import com.datastax.driver.core.policies.DefaultRetryPolicy;
import com.datastax.driver.core.policies.LoggingRetryPolicy;

public class StacksDao {

	public void  CreateConeection () {
		Cluster cluster = null;
	
	try{
		QueryOptions qOptions = new QueryOptions().setConsistencyLevel(ConsistencyLevel.LOCAL_QUORUM);
	
		 cluster = Cluster.builder()
	        .addContactPoint("35.202.155.87")
	        .withCredentials("cassandra", "cassandra")
	        .withQueryOptions(qOptions)
	        .withRetryPolicy(new LoggingRetryPolicy(DefaultRetryPolicy.INSTANCE))
	        .withReconnectionPolicy(new ConstantReconnectionPolicy(TimeUnit.SECONDS.toMillis(5))).build();
	              
	
} finally { if ( cluster != null) {cluster.close() ; }
}
}
}