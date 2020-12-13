import com.infa.market.cache.helpers.DefaultCache;
import com.infa.market.cache.models.CacheEvictionPolicies;
import com.infa.market.cache.helpers.InitializeCacheFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {



	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Enter data using BufferReader
		BufferedReader reader =
				new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter capacity");
		int cacheSize = Integer.parseInt(reader.readLine());
//		CacheEvictionPolicies cacheEvictionPolicies = CacheEvictionPolicies cacheEvictionPolicies(args[1]);
		System.out.println("Press 1.For LRU Cache Invalidation technique");
		System.out.println("Press 2.For MRU Cache Invalidation technique");
		int cacheTechnique = Integer.parseInt(reader.readLine());
		CacheEvictionPolicies cacheEvictionPolicies = cacheTechnique == 1?CacheEvictionPolicies.LRU:CacheEvictionPolicies.MRU;


		System.out.println("Press 0.To initialize Cache with 3 values \n" +
				" \n1 10 \n 2 20 \n 3 30 \n 4 40");
		System.out.println("Press 1.To insert key value separated with space");
		System.out.println("Press 2.To Get Value");
		System.out.println("Press 3.Check state of cache");
		System.out.println("Press 4.To Exit");


		// Reading data using readLine
		int userInput =Integer.parseInt(reader.readLine());
		DefaultCache defaultCache = InitializeCacheFactory.getInstance(cacheSize)
				.initCache(cacheEvictionPolicies)
				.getCache();
		while(userInput !=4)
		{
			switch (userInput){
				case 0:
					defaultCache.insert(1,10)
					.insert(2, 20)
					.insert(3, 30)
					.insert(4, 40);
					break;
				case 1:
					System.out.println("Insert Key");
					int key = Integer.parseInt(reader.readLine());
					System.out.println("Insert Value");
					int value = Integer.parseInt(reader.readLine());
					defaultCache.insert(key, value);
					break;
				case 2:
					System.out.println("Insert Key");
					int key1 = Integer.parseInt(reader.readLine());
					System.out.println(InitializeCacheFactory.getInstance().getCache().getValue(key1));
					break;
				case 3:
					System.out.println("Cache Status is");
					System.out.println(InitializeCacheFactory.getInstance().getCache().getData());
					break;
				case 4:
					System.exit(0);
			}
			userInput =Integer.parseInt(reader.readLine());

		}

	}


}
