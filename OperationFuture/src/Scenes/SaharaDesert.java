package Scenes;

import java.util.ArrayList;

import Characters.Alien;
import Characters.BossAlien;
import Characters.SoldierAlien;
import Main.Pilot;
import Main.Rating;
import Map.State;
import UI.UI;

public class SaharaDesert extends Location implements State{
	
	private UI ui = new UI();
	
	public SaharaDesert() {
		
		name = "Sahara Desert";
			
		aliens = new ArrayList<Alien>();
		
		Rating SoldierRating = new Rating(250, 250, 250, 250);
		Rating BossRating = new Rating(500, 200, 0, 300);

		
		SoldierAlien a1 = new  SoldierAlien("Soldier Alien 1", SoldierRating);
		SoldierAlien a2 = new  SoldierAlien("Soldier Alien 2", SoldierRating);
		BossAlien b1 = new 	BossAlien("Boss Alien", BossRating);
		
		
		aliens.add(a1);
		aliens.add(a2);
		aliens.add(b1);
		
	}	
	

	@Override
	public void next(Pilot currentLocation) {
		currentLocation.setState(new NightCity());
	}

	
	@Override
	public void printStatus() {
		
		ui.print("Traveling to "+name); try {
			ui.animateText("...", 3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ui.println("\nHQ: You have now arrived at: "+name+"!\n");
		ui.println("          . _..::__:  ,-\"-\"._       |]       ,     _,.__              \n"
				+ "  _.___ _ _<_>`!(._`.`-.    /        _._     `_ ,_/  '  '-._.---.-.__ \n"
				+ ".{     \" \" `-==,',._\\{  \\  / {)     / _ \">_,-' `                 /-/_ \n"
				+ " \\_.:--.       `._ )`^-. \"'      , [_/(                       __,/-'  \n"
				+ "'\"'     \\         \"    _L       |-_,--'          "+ui.colorText("\u25C9 Prominent City", 255,0,0)+" /. (|    \n"
				+ "         |        "+ui.colorText("\u25C9 Night city", 255, 0,0)+"    _)_.\\\\._<> {}              _,' /  '   \n"     //green 51,204,51
				+ "         `.         /          [_/_'` `\"(                <'}  )       \n"
				+ "          \\\\    .-. )          /   `-'\"..'  "+ui.colorText("\u25C9 HQ", 192,192,192)+"            _)  '        \n"
				+ "            \\  (  `(          /         `:\\  > \\  ,-^.  /' '          \n"
				+ "             `._,   \"\"        | "+ui.colorText("Sahara Desert", 0,0,255)+"   \\`'   \\|   ?_)  {\\          \n"
				+ "                `=.---.       `._._       ,'     \"`  |' ,- '.         \n"
				+ "                  |    `-._        |     /          `:`<_|=--._       \n"
				+ "   "+ ui.colorText("Pacific Ocean", 255, 0, 0) +"  (        >       .     | ,          `=.__.`-'\\      \n"
				+ "                   `.     /        |     |{|              ,-.,\\     . \n"
				+ "                    |   ,'          \\   / `'            ,\"     \\      \n"
				+ "                    |  /             |_'                |  __  /      \n"
				+ "                    | |                                 '-'  `-'   \\. "+ui.colorText("\u25C9 Hidden Location", 110, 0,4)+" \n"
				+ "                    |/                                        \"    /  \n"
				+ "                    \\.                                            '      \n"
				+ "                                                                             .—---------------------.\n"
				+ "                     ,/           ______._.--._ _..---.---------.            | "+ui.colorText("\u25C9 Current Location", 0,0,255)+"   |\n"
				+ "__,-----\"-..?----_/ )\\    . ,-'\"             \"                  (__--/       | "+ui.colorText("\u25C9 Cleared Location", 51,204,51)+"   |\n"
				+ "                      /__/\\/              Antarctica                         | "+ui.colorText("\u25C9 Remaining Location", 255, 0, 0)+" | \n"
				+ " 									      —---------------------		      			\n"
				+ "------------------------------------------------------------------------------------------------------");
		
		ui.println("Based on our analysis, here are all the information about the enemy demographic present here:\n");
		
		
		for(int i=0; i <aliens.size(); i++) {
			
			ui.println("- "+aliens.get(i).printAlien());
		}
		
	}

	@Override
	public void printGrid() {
		ui.println("                                                                                                  \n"
				+ "                 █████████████████                                                                                                                                                                                  \n"
				+ "                 █               █                                                            \n"
				+ "                 █               █                                                            \n"
				+ "                 █     ITEM      █                                                            \n"
				+ "                 █               █                                                            \n"
				+ "                 █               █                                                            \n"
				+ " █████████████████████████████████                                                            \n"
				+ " █               █               █                                                            \n"
				+ " █               █               █                                                            \n"
				+ " █     ITEM      █ SOLDIER ALIEN █                                                            \n"
				+ " █               █               █                                                            \n"
				+ " █               █               █                                                                                                                                       \n"
				+ " ██████████████████████████████████████████████████████████████████████████████████      \n"
				+ " █               █               █               █               █                █       \n"
				+ " █               █               █               █               █                █       \n"
				+ " █     YOU       █               █               █ SOLDIER ALIEN █                █       \n"
				+ " █               █               █               █               █                █       \n"
				+ " █               █               █               █               █                █          \n"
				+ " ██████████████████████████████████████████████████████████████████████████████████      \n"
				+ "                                 █               █               █                         \n"
				+ "                                 █               █               █                         \n"
				+ "                                 █     ITEM      █               █                         \n"
				+ "                                 █               █               █                         \n"
				+ "                                 █               █               █                         \n"
				+ "                                 █████████████████████████████████                        \n"
				+ "                                                 █               █                         \n"
				+ "                                                 █               █                         \n"
				+ "                                                 █  BOSS ALIEN   █                         \n"
				+ "                                                 █               █                         \n"
				+ "                                                 █               █                         \n"
				+ "                                                 █████████████████                        \n"
				+ "                                                                           \n"
				+ "                                                                                                    \n");
		
	}
}
