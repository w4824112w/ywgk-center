package com.gkyt.ywgk.center;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * 使用本地redis库，简单测试java链接redis的使用方式，包括列表、字符串、集合等类型
 * 
 * @author hk
 *
 **/
public class TestRedis {

	public static void main(String[] args) {
		// connection();
		// redisString();
		// redisList();
		// redisSet();
		
		//连接本地的 Redis 服务
		Jedis jedis = new Jedis("192.168.0.121",6379);
		System.out.println("Connection to server sucessfully");
		//查看服务是否运行
		System.out.println("Server is running: "+jedis.ping());

	}

	public static void redisSet() {
		Jedis jedis = new Jedis("120.78.190.101");
		Set<String> list = jedis.keys("*");
		Iterator<String> ite = list.iterator();
		while (ite.hasNext()) {
			String key = ite.next();
			System.out.println("List of stored keys : " + key);
		}
	}

	public static void redisList() {
		Jedis jedis = new Jedis("120.78.190.101");
		jedis.lpush("tutorial-list", "Redis");
		jedis.lpush("tutorial-list", "Mongodb");
		jedis.lpush("tutorial-list", "Mysql");

		List<String> list = jedis.lrange("tutorial-list", 0, 5);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Stroed string in redis : " + list.get(i));
		}
	}

	public static void redisString() {
		Jedis jedis = new Jedis("120.78.190.101");
		jedis.set("nameIs", "renqiang");
		System.out.println("Stored string in redis : " + jedis.get("nameIs"));
	}

	public static void connection() {
		Jedis jedis = new Jedis("localhost");
		System.out.println(jedis.ping());
		Transaction t = jedis.multi();
		t.exec();
	}

}
