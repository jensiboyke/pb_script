package com.test.strategies;


import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.interactive.NPC;

import com.test.framework.implementation.Strategy;

public class MoveBank implements Strategy 
{
	Tile[] NaarBank = new Tile[] {  new Tile(2724, 3430, 0), new Tile(2725, 3434, 0), new Tile(2728, 3439, 0),
			 new Tile(2728, 3444, 0), new Tile(2729, 3449, 0), new Tile(2731, 3455, 0),
			 new Tile(2730, 3460, 0), new Tile(2728, 3465, 0), new Tile(2725, 3478, 0),
			 new Tile(2725, 3491, 0), new Tile(2725, 3492, 0), new Tile(2726, 3494, 0) };
	
	private final static int bankman =494;
	private static boolean gedaan = true;
	
	@Override
	public boolean isValid() 
	{
		NPC bankmeneer = NPCs.getNearest(bankman);
		return bankmeneer == null&&Inventory.isFull()&& gedaan;
	}

	@Override
	public int execute() 
	{
		Walking.newTilePath(NaarBank).traverse(); System.out.println("lopen naar de bank");
	    Camera.setNorth();System.out.println("camera naar bank gedraait");
		
		NPC bankmeneer = NPCs.getNearest(bankman);
		if (bankmeneer != null){
			bankmeneer.interact("Bank"); System.out.println("Banken begonnen"); gedaan = false; System.out.println("volgende class");}
			
		return 0;
	}
}
