package game.objects;


public class GameObjectFactory {
	private GameObject fruit;
	public GameObjectFactory () {
		
		
	}
	public GameObject CreateGameObject(int num) {
		switch (num) {
		case 0:

			fruit = new Peach();
			//fruit.setX(xLoc);
			//fruit.setY(yLoc);
			break;
		case 1:
			fruit = new Watermelon();
			
		break;
		case 2:
			fruit = new Banana();
			
		break;

		case 3:
			fruit = new DangerousBomb();
			
		break;
		
		case 4:
			fruit = new FatalBomb();
			
		break;
		case 5:
			fruit = new SpecialBanana5();
			
		break;
		case 6:
			fruit = new SpecialBanana10();
			
		break;
		
		default:
			break;
		}
		
		
		
		
		return fruit;

	}


}
