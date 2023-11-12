package Scenes;

import Main.Pilot;
import Map.State;
import UI.UI;

public class HQ_ extends Location implements State{
	
	private UI ui = new UI();

	public HQ_() {
		name = "The HQ";		
	}
	

	@Override
	public void next(Pilot currentLocation) {
		currentLocation.setState(new SaharaDesert());
	}

	@Override
	public void printStatus() {
		ui.println("          . _..::__:  ,-\"-\"._       |]       ,     _,.__              \n"
				+ "  _.___ _ _<_>`!(._`.`-.    /        _._     `_ ,_/  '  '-._.---.-.__ \n"
				+ ".{     \" \" `-==,',._\\{  \\  / {)     / _ \">_,-' `                 /-/_ \n"
				+ " \\_.:--.       `._ )`^-. \"'      , [_/(                       __,/-'  \n"
				+ "'\"'     \\         \"    _L       |-_,--'          "+ui.colorText("\u25C9 Prominent City", 255,0,0)+" /. (|    \n"
				+ "         |        "+ui.colorText("\u25C9 Night city", 255, 0,0)+"    _)_.\\\\._<> {}              _,' /  '   \n"     //green 51,204,51
				+ "         `.         /          [_/_'` `\"(                <'}  )       \n"
				+ "          \\\\    .-. )          /   `-'\"..'  "+ui.colorText("\u25C9 HQ", 0,0,255)+"            _)  '        \n"
				+ "            \\  (  `(          /         `:\\  > \\  ,-^.  /' '          \n"
				+ "             `._,   \"\"        | "+ui.colorText("Sahara Desert", 255, 0, 0)+"   \\`'   \\|   ?_)  {\\          \n"
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
		
	}

	@Override
	public void printGrid() {
		//no grid
	}

}
