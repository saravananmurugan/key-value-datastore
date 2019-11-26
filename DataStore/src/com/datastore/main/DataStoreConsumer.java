package com.datastore.main;

import org.json.simple.JSONObject;

public class DataStoreConsumer {
	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("firstName", "saravanan");
		jsonObject.put("lastName", "murugan");
		jsonObject.put("address", "india");
		// Create Operation
		// DataStore datastore = new DataStore();
		DataStore datastore = new DataStore(
				"C:\\Users\\saravanan\\Documents\\DataStore");
		System.out.println(datastore.create("1", jsonObject, 10));// success
		System.out.println(datastore.create("1", jsonObject));// failure
		System.out.println(datastore.create("1", jsonObject, 10));// failure
		System.out.println(datastore.create("2", jsonObject));// success
		System.out.println(datastore.create(
				"keynamevalidation", new JSONObject()));// failure
		try {
			// wait for 10 seconds
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsonObject.put("age", "22");
		System.out.println(datastore.create("1", jsonObject, 10));// success
		System.out.println(datastore.create("1", jsonObject));// failure
		System.out.println(datastore.create("1", jsonObject, 10));// failure
		System.out.println(datastore.create("2", jsonObject));// failure

		// Read Operation
		System.out.println(datastore.read("1"));// success
		System.out.println(datastore.read("2"));// success
		System.out.println(datastore.read("3"));// failure
		System.out.println(datastore
				.read("namecheckvalidation"));// failure
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(datastore.read("1"));// failure
		System.out.println(datastore.read("2"));// success

		System.out.println(datastore.delete("1"));// failure
		System.out.println(datastore.delete("2"));// success
		System.out.println(datastore.delete("2"));// failure
		System.out.println(datastore.delete("3"));// failure
		System.out.println(datastore
				.delete("namecheckvalidation"));// failure
	}
}
