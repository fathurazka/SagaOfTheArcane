package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_Gold extends SuperObject {
	
	public OBJ_Gold(){
		
		name = "Gold";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/object/gold.png"));
		} catch (IOException  e) {
			e.printStackTrace();
		}
				
	}
}
