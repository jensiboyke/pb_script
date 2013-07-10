package com.test.framework;

import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;

import com.test.framework.implementation.Strategy;

public class StrategyHandler {

	private static final LinkedList<Strategy> STRATEGY_LIST = new LinkedList<>();

	public static void add(final Strategy... strategies) {
		Collections.addAll(STRATEGY_LIST, strategies);
	}

	public static int loop() {
		try {
			for (final Strategy strategy : STRATEGY_LIST) {
				try {
					if (strategy.isValid()) {
						return strategy.execute();
					}
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		} catch (final ConcurrentModificationException ignored) {

		}
		return 20; //Default delay
	}
}