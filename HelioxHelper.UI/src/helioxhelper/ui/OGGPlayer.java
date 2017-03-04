/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helioxhelper.ui;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author kevin
 */
public class OGGPlayer {
    
    SourceDataLine line;
    AudioInputStream din = null;
    byte[] data;
    String filepath;
    
public OGGPlayer(String filepath){
    this.filepath=filepath;
}
    public void play() {
        
        
        try
  {
    File file = new File(filepath);
    // Get AudioInputStream from given file.	
    AudioInputStream in= AudioSystem.getAudioInputStream(file);
    this.din = null;
    if (in != null)
    {
        AudioFormat baseFormat = in.getFormat();
        AudioFormat  decodedFormat = new AudioFormat(
                AudioFormat.Encoding.PCM_SIGNED,
                baseFormat.getSampleRate(),
                16,
                baseFormat.getChannels(),
                baseFormat.getChannels() * 2,
                baseFormat.getSampleRate(),
                false);
         // Get AudioInputStream that will be decoded by underlying VorbisSPI
        din = AudioSystem.getAudioInputStream(decodedFormat, in);
         this.data = new byte[4096];
  this.line = getLine(decodedFormat);
   if (line != null)
  {
     // Start
    line.start();
     int nBytesRead = 0, nBytesWritten = 0;
     while (nBytesRead != -1)
    {
        nBytesRead = din.read(data, 0, data.length);
         if (nBytesRead != -1) nBytesWritten = line.write(data, 0, nBytesRead);
    }
     // Stop
    line.drain();
    line.stop();
    line.close();
    din.close();
  }		
    }
  }
  catch (Exception e)
  {
    e.printStackTrace();
  }
        
}
    




public void stop()
{
  	
  if (line != null)
  {
    
    line.stop();
    line.close();
      try {
          din.close();
      } catch (IOException ex) {
          Logger.getLogger(OGGPlayer.class.getName()).log(Level.SEVERE, null, ex);
      }
  }		
}


private SourceDataLine getLine(AudioFormat audioFormat) throws LineUnavailableException
{
  SourceDataLine res = null;
  DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
  res = (SourceDataLine) AudioSystem.getLine(info);
  res.open(audioFormat);
  return res;
}
    
}