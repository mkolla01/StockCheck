package com.abab.stocks.dao;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.abab.stocks.domain.Stocks;
import com.abab.stocks.utilities.StockUtilities;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.QueryOptions;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.policies.ConstantReconnectionPolicy;
import com.datastax.driver.core.policies.DefaultRetryPolicy;
import com.datastax.driver.core.policies.LoggingRetryPolicy;
@Service("stockDao")
public class StocksDao {

	public Cluster  createCluster (Cluster cluster) throws Exception {
		
	Properties prop = StockUtilities.readProperties("database");
	try{
		
		QueryOptions qOptions = new QueryOptions().setConsistencyLevel(ConsistencyLevel.LOCAL_QUORUM);
	
		 cluster = Cluster.builder()
	        .addContactPoint(prop.getProperty("db.cassandra.contactpoint"))
	        .withCredentials(prop.getProperty("db.user.name"), prop.getProperty("db.user.password"))
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
			
		session = cluster.connect("abab_1");
		String sql = "select * from mystocks";
		Row rs = session.execute(sql).one();
		
		if ( rs != null){
			
			System.out.println(rs.getString("stocksymbol"));
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
		StocksDao stocksDao = new StocksDao();
		try{
			
			//stacksDao.selectAccess();
			stocksDao.listStocks();
		} catch(Exception e){
			System.out.println("Caught exception while creating cluster"+e);
		}
		
		
	}
	public ArrayList<Stocks> listStocks() throws Exception {
		ArrayList<Stocks> arrayList = new ArrayList<Stocks>();
		Cluster cluster = null;
		Session session = null;
		try{
		cluster = createCluster ( cluster); 
		
		//Session session = null;
			
		session = cluster.connect("abab_1");
		String sql = "select * from mystocks";
		ResultSet rs = session.execute(sql);
		
		while ( !rs.isExhausted()){
			Stocks stocks = new Stocks();
			Row row = rs.one();
			stocks.setSymbol(row.getString("stocksymbol"));
			stocks.setHighprc(row.getDouble("highprice"));
			arrayList.add(stocks);
			System.out.println(arrayList);
		}
		
		}catch (Exception e){ 
			//System.out.println("Caught exception while creating cluster"+e);
			throw e;
		}
		finally{ 
			session.close();
			cluster.close();
		}
		
		return arrayList;
		
	}
}