package Scenes;

import java.util.ArrayList;

import Characters.Alien;
import Characters.BossAlien;
import Characters.SoldierAlien;
import Main.Rating;

public class SaharaDesert extends Location {
	
	public SaharaDesert() {
		name = "Sahara Desert";
		
		map = "          . _..::__:  ,-\"-\"._       |]       ,     _,.__              \n"
				+ "  _.___ _ _<_>`!(._`.`-.    /        _._     `_ ,_/  '  '-._.---.-.__ \n"
				+ ".{     \" \" `-==,',._\\{  \\  / {)     / _ \">_,-' `                 /-/_ \n"
				+ " \\_.:--.       `._ )`^-. \"'      , [_/(                       __,/-'  \n"
				+ "'\"'     \\         \"    _L       |-_,--'          "+colorText("\u25C9 Prominent City", 255,0,0)+" /. (|    \n"
				+ "         |        "+colorText("\u25C9 Night city", 255, 0,0)+"    _)_.\\\\._<> {}              _,' /  '   \n"
				+ "         `.         /          [_/_'` `\"(                <'}  )       \n"
				+ "          \\\\    .-. )          /   `-'\"..'  "+colorText("\u25C9 HQ", 192,192,192)+"            _)  '        \n"
				+ "            \\  (  `(          /         `:\\  > \\  ,-^.  /' '          \n"
				+ "             `._,   \"\"        | "+colorText("Sahara Desert", 51,204,51)+"   \\`'   \\|   ?_)  {\\          \n"
				+ "                `=.---.       `._._       ,'     \"`  |' ,- '.         \n"
				+ "                  |    `-._        |     /          `:`<_|=--._       \n"
				+ "   "+ colorText("Pacific Ocean", 255, 0, 0) +"  (        >       .     | ,          `=.__.`-'\\      \n"
				+ "                   `.     /        |     |{|              ,-.,\\     . \n"
				+ "                    |   ,'          \\   / `'            ,\"     \\      \n"
				+ "                    |  /             |_'                |  __  /      \n"
				+ "                    | |                                 '-'  `-'   \\. "+colorText("\u25C9 Hidden Location", 110, 0,4)+" \n"
				+ "                    |/                                        \"    /  \n"
				+ "                    \\.                                            '   \n"
				+ "                                                                      \n"
				+ "                     ,/           ______._.--._ _..---.---------.     \n"
				+ "__,-----\"-..?----_/ )\\    . ,-'\"             \"                  (__--/\n"
				+ "                      /__/\\/              Antarctica                            \n"
				+ "-----------------------------------------------------------------------------------------";
		
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
	
	public static String colorText( String text, int r, int g, int b ) 
	{
		return "\u001b[38;2;" + r + ";" + g + ";" + b + "m" + text + "\u001b[0m";
	}
}
