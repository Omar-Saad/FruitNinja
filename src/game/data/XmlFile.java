package game.data;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;



public class XmlFile {
	
	private int highscore;
	private Score s;
	
	public XmlFile() {

	s = new Score();
	
	}
	public int getHighscore() {
		
		
			
			JAXBContext jaxbContext;
			try {
				jaxbContext = JAXBContext.newInstance(Score.class);
				
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				s = (Score) unmarshaller.unmarshal(new File("score.xml"));
				highscore = s.getHighscore();
				  				  
				  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		
		return highscore;
		}
	public void setHighscore(int highscore) {
		
		JAXBContext jaxbContext;
		try {
			s.setHighscore(highscore);
			jaxbContext = JAXBContext.newInstance(Score.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(s, new File("score.xml"));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	

}
