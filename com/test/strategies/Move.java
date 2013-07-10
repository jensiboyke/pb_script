package com.test.strategies;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.interactive.NPC;

import com.test.framework.implementation.Strategy;

public class Move implements Strategy 
{
	//declareren tiles
	Tile[] NaarFM = new Tile[] { new Tile(2725, 3492, 0), new Tile(2726, 3486, 0), new Tile(2726, 3480, 0),
			 new Tile(2726, 3474, 0), new Tile(2725, 3468, 0), new Tile(2725, 3461, 0),
			 new Tile(2724, 3456, 0), new Tile(2724, 3451, 0), new Tile(2722, 3444, 0),
			 new Tile(2722, 3440, 0), new Tile(2722, 3433, 0), new Tile(2719, 3432, 0),
			 new Tile(2725, 3432, 0) };
	
	//declareren NPC
	private final int Vuurman = 4946;
	
	@Override
	public boolean isValid() 
	{
		//Controleren: NPC in de buurt & Inventory not full
		NPC VuurMan = NPCs.getNearest(Vuurman);	
		return VuurMan == null && !Inventory.isFull() && !Bank.isOpen();
	}

	@Override
	public int execute() 
	{
		//OPDRACHT: Loop naar plaats
		NPC VuurMan = NPCs.getNearest(Vuurman);	
		if (VuurMan == null)
		{
			Walking.newTilePath(NaarFM).traverse();System.out.println("lopn naar FM");
		}
		if(VuurMan != null){Camera.turnTo(VuurMan);System.out.println("Camera naar FM");}
		return 0;
	}
}
