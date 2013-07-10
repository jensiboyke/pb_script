package com.test.strategies;

import org.powerbot.core.script.job.Task;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.wrappers.interactive.NPC;

import com.test.framework.implementation.Strategy;

public class Deposit implements Strategy 
{
	private final static int[] bankman ={494,495};
	private static boolean gedaan = true;
	@Override
	public boolean isValid() {
		NPC bankmeneer = NPCs.getNearest(bankman);
		return bankmeneer != null && gedaan;
	}

	@Override
	public int execute() 
	{
		NPC bankmeneer = NPCs.getNearest(bankman);
		if (bankmeneer != null)
		{
			
			/*while(!Bank.isOpen())
			{
				Task.sleep(50);
			}*/
			if (Bank.isOpen()){Bank.depositInventory();System.out.println("alles erop gezet");}
			if (!Inventory.isFull() & Bank.isOpen() )
			{ 
				Bank.close();System.out.println("Bank sluiten"); gedaan = false; System.out.println("Volgende class");
			}
		}
		return 0;
	}
}
