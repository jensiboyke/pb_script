package com.test.strategies;

import org.powerbot.core.script.job.Task;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

import com.test.framework.implementation.Strategy;

public class VindNPC implements Strategy 
{
	private final static int VuurMan = 4946;
	private static boolean gedaan = true;
	
	@Override
	public boolean isValid() {
		NPC Vuurman = NPCs.getNearest(VuurMan);
		return Vuurman != null &&!Inventory.isFull() && gedaan != false ;
	}

	@Override
	public int execute() 
	{
		NPC Vuurman = NPCs.getNearest(VuurMan);
		Camera.turnTo(Vuurman); System.out.println("camera draaien FM");
		if(Vuurman.isOnScreen())
		{
			Vuurman.interact("Trade"); System.out.println("getraded met FM");
		}
		while(!Widgets.get(1265).validate())
		{
			Task.sleep(15,30);
		}
	
		WidgetChild VuurmanKlik = Widgets.get(1265,20).getChild(0);
		if(VuurmanKlik != null)
		{
			if(VuurmanKlik.validate() && VuurmanKlik.visible())
			{
		
				VuurmanKlik.interact("Buy All");System.out.println("tinderboxes gekocht");
				gedaan = false;System.out.println("volgende class");
			}
		}
		return 0;
}
}