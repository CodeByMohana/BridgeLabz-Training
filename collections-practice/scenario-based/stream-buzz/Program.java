package com.scenariobased.collections.streambuzz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

	public void RegisterCreator(CreatorStats record) {
		CreatorStats.engagementBoard.add(record);
	}

	public Map<String, Integer> getTopPostCounts(List<CreatorStats> records, double likeThreshold) {
		Map<String, Integer> result = new HashMap<String, Integer>();

		for (CreatorStats creatorStats : records) {
			int count = 0;
			for (double likes : creatorStats.weeklyLikes) {
				if (likes > likeThreshold) {
					count++;
				}
			}

			if (count > 0) {
				result.put(creatorStats.creatorName, count);
			}
		}
		return result;
	}

	public double CalculateAverageLikes() {
		return CreatorStats.engagementBoard.stream().flatMapToDouble(c -> Arrays.stream(c.weeklyLikes)).average()
				.orElse(0.0);
	}
}
