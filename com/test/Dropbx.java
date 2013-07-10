package com.test;

import org.powerbot.game.api.Manifest;
import org.powerbot.core.script.ActiveScript;

import com.test.framework.StrategyHandler;
import com.test.strategies.Deposit;
import com.test.strategies.Move;
import com.test.strategies.MoveBank;
import com.test.strategies.VindNPC;

@Manifest(authors = "Naam", name = "Dropbx", version = 1.0, description = "")
public class Dropbx extends ActiveScript
{
	@Override
	public void onStart() {
		StrategyHandler.add(new Move(), new VindNPC(), new MoveBank(), new Deposit());
	}

	@Override
	public int loop() {
		return StrategyHandler.loop();
	}
	}
