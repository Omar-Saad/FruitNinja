package game.level;

public class LevelFctory {
	
	private ILevel level;
	
	public  ILevel createLevel(int levelnum) {
		
		switch (levelnum) {
		case 0:
			
			level = new EasyLevel();
			break;

case 1:
			
			level = new MediumLevel();
			break;
case 2:
	
	level = new HardLevel();
	break;

		default:
			break;
		}
		
		
		return level;
	}

}
