/*
 * Copyright (C) 2016 Mariana
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.proyectoHeliox.helper.negocio;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import org.proyectoHeliox.helper.persistencia.BotonPersistencia;
import org.proyectoHeliox.helper.persistencia.LenguajePersistencia;

/**
 *
 * @author Mariana
 */
public class DefaultValues {
    String active = System.getProperty("user.dir");
    BotonPersistencia b = new BotonPersistencia();
    LenguajePersistencia l = new LenguajePersistencia();

    public void agregarLenguajes() throws SQLException, IOException {
        l.agregarLenguaje("Español", System.getProperty("user.dir") + File.separator+ "icons/mexico.png" );
        l.agregarLenguaje("Maya", System.getProperty("user.dir") + File.separator+ "icons/mexico.png" );
        l.agregarLenguaje("Nahuatl", System.getProperty("user.dir") + File.separator+ "icons/mexico.png" );
        l.agregarLenguaje("Quechua", System.getProperty("user.dir") + File.separator+ "icons/peru.png" );
        l.agregarLenguaje("Mixe", System.getProperty("user.dir") + File.separator+ "icons/mixe.png");

           System.out.println("Agregados Lenguajes");
           
    }
//        String rutaIcon, String descripcion, String rutaEjecutable, String rutaAudio, int idLenguaje) 

    public void agregarBotones() throws SQLException, IOException {
        //Español
 
        b.agregarBoton(active +"\\icons\\ley.png", "Consulta la Ley General de Derechos Lingüísticos de los Pueblos Indígenas", active +"\\material\\ley-es.pdf", active +"\\speech\\es_MX\\ley_es_MX.ogg", 1);
        b.agregarBoton(active +"\\icons\\inali.png", "Consulta el Catálogo de las Lenguas Indígenas Nacionales", "http://inali.gob.mx/clin-inali/", active +"\\speech\\es_MX\\catalogo_es_MX.ogg", 1);
        b.agregarBoton(active +"\\icons\\10cosas.png", "Lee el texto sobre “10 cosas que todo hablante debe saber acerca de su lengua”", active +"\\material\\10cosas-es.pdf", active+"\\speech\\es_MX\\10cosas_es_MX.ogg", 1);
        b.agregarBoton(active +"\\icons\\enadis.png", "Consulta la Encuesta Nacional de Discriminación 2012", active +"\\material\\enadis-es.pdf", active +"\\speech\\es_MX\\encuesta2012_es_MX.ogg", 1);
        b.agregarBoton(active +"\\icons\\videos.png", "Accede a la carpeta para ver videos en Castellano", active +"\\material\\VideosEnIdiomas", active +"\\speech\\es_MX\\carpeta_es_MX.ogg", 1);
        b.agregarBoton(active +"\\icons\\inali.png", "Accede al sitio web del Instituto Nacional de Lenguas Indígenas", "http://inali.gob.mx", active +"\\speech\\es_MX\\inali_es_MX.ogg", 1);
        b.agregarBoton(active +"\\icons\\compartiendosaberes.png", "Accede al sitio web de Compartiendo Saberes", "http://www.compartiendo-saberes.org/",active +"\\speech\\es_MX\\firefox http_--www.compartiendosaberes.org_es_MX.ogg", 1);
        b.agregarBoton(active +"\\icons\\guardavoces.png", "Consulta el enlace para niños “Los Guardavoces”", "http://site.inali.gob.mx/guarda_voces/", active +"\\speech\\es_MX\\guardavoces_es_MX.ogg", 1);
        b.agregarBoton(active +"\\icons\\firefox.png", "Busca información y explora la Red Internet con FIREFOX", "firefox", active +"\\speech\\es_MX\\firefox_es_MX.ogg", 1);
//        b.agregarBoton(active +"\\icons\\libreoffice.png", "Escribe tus documentos con LIBREOFFICE", "libreoffice", active +"\\speech\\es_MX\\libreoffice_es_MX.ogg", 1);
//        b.agregarBoton(active +"\\icons\\gpicview.png", "Organiza tus fotografías con GPICVIEW", "gpicview", active +"\\speech\\es_MX\\gpicview_es_MX.ogg", 1);
        b.agregarBoton(active +"\\icons\\vlc.png", "Reproduce tus videos y tu música con VLC", "vlc", active +"\\speech\\es_MX\\vlc_es_MX.ogg", 1);
//        b.agregarBoton(active +"\\icons\\pidgin.png", "Habla con tus amigos con PIDGIN", "pidgin", active +"\\speech\\es_MX\\pidgin_es_MX.ogg", 1);
//        b.agregarBoton(active +"\\icons\\okular.png", "Lee todo tipo de documentos con OKULAR", "okular", active +"\\speech\\es_MX\\okular_es_MX.ogg", 1);
//        b.agregarBoton(active +"\\icons\\transmission.png", "Comparte tus archivos con TRANSMISSION", "transmission", active +"\\speech\\es_MX\\transmission_es_MX.ogg", 1);
//        b.agregarBoton(active +"\\icons\\brasero.png", "Graba tus CDs o DVDs con BRASERO", "brasero", active +"\\speech\\es_MX\\brasero_es_MX.ogg", 1);
//        b.agregarBoton(active +"\\icons\\cheese.png", "Graba imágenes y videos con tu cámara Web", "cheese", active +"\\speech\\es_MX\\cheese_es_MX.ogg", 1);
        b.agregarBoton(active +"\\icons\\audacity.png", "Graba sonido y edita tus grabaciones con AUDACITY", "audacity", active +"\\speech\\es_MX\\audacity_es_MX.ogg", 1);
//        b.agregarBoton(active +"\\icons\\openshot.png", "Edita tus grabaciones de vídeo con OPENSHOT", "openshot", active +"\\speech\\es_MX\\openshot_es_MX.ogg", 1);
//        b.agregarBoton(active +"\\icons\\kmag.png", "Amplia la pantalla con KMAG", "kmag", active +"\\speech\\es_MX\\kmag_es_MX.ogg", 1);
//        b.agregarBoton(active +"\\icons\\onboard.png", "Activa un teclado en la pantalla", "onboard", active +"\\speech\\es_MX\\onboard_es_MX.ogg", 1);
 //       b.agregarBoton(active +"\\icons\\eviacam.png", "Mueve el ratón con tu cabeza con EVIACAM", "enviacam", active +"\\speech\\es_MX\\enviacam_es_MX.ogg", 1);
//        b.agregarBoton(active +"\\icons\\xrandr.png", "Ajusta tu monitor o pantalla", "mate-display-properties", active +"\\speech\\es_MX\\xrandr_es_MX.ogg", 1);
//        b.agregarBoton(active +"\\icons\\terminal.png", "Abre una TERMINAL para manejar tu sistema mediante la línea de comandos", "exterm", active +"\\speech\\es_MX\\xterm_es_MX.ogg", 1);
                b.agregarBoton(active +"\\icons\\icon.png", "HELIOX es un sistema operativo basado en software libre y orientado a la atención a la diversidad funcional y cultural.", active +"http://www.proyectoheliox.org", active +"\\speech\\es_MX\\ProyectoHeliox_es_MX.ogg", 1);
        
        //Maya
        b.agregarBoton(active +"\\icons\\ley.png", "Il a wil u Noj A'almaj T'aanil u Páajtalil u T'a'anal Máasewal T’aano’ob.", active +"\\material\\ley-myn.pdf", active +"\\speech\\myn_MX\\ley_myn_MX.ogg", 2);
        b.agregarBoton(active +"\\icons\\inali.png", "Il a wil u Ju’unil u Máasewal T’aano’ob u Noj Lu’umil México", "http://inali.gob.mx/clin-inali/", active +"\\speech\\myn_MX\\catalogo_myn_MX.ogg", 2);
        b.agregarBoton(active +"\\icons\\10cosas.png", "Xook le ts’íiba “Lajunp’éel ba’alob ti’ le t’aan k’aabet u yojeltik tuláakal máak ku t’aan", active +"\\material\\10cosas-myn.pdf", active+"\\speech\\myn_MX\\10cosas_myn_MX.ogg", 2);
        b.agregarBoton(active +"\\icons\\enadis.png", "Il a wil u Noj K’aatchi’il ti’ P’eekta’anil 2012", active +"\\material\\enadis-es.pdf", active +"\\speech\\myn_MX\\encuesta2012_myn_MX.ogg", 2);
        b.agregarBoton(active +"\\icons\\videos.png", "Oken te’ kúuchila’ ti’al a wilik videos ich maaya t’aan", active +"\\material\\VideosEnIdiomas", active +"\\speech\\myn_MX\\carpeta_myn_MX.ogg", 2);
        b.agregarBoton(active +"\\icons\\inali.png", "Oken ti’ u kúuchil Instituto Nacional de Lenguas Indígenas", "http://inali.gob.mx", active +"\\speech\\myn_MX\\inali_myn_MX.ogg", 2);
        b.agregarBoton(active +"\\icons\\compartiendosaberes.png", "Oken ti’ u kúuchil Múuch’ Keet Túukulo’ob", "http://www.compartiendo-saberes.org/",active +"\\speech\\myn_MX\\firefox-maya http_--www.compartiendosaberes.org_myn_MX.ogg", 2);
        b.agregarBoton(active +"\\icons\\guardavoces.png", "Il a wil le kúuchil utia’al mejen paalal “J kanáan t’aano’ob”", "http://site.inali.gob.mx/guarda_voces/", active +"\\speech\\myn_MX\\guardavoces_myn_MX.ogg", 2);
        b.agregarBoton(active +"\\icons\\firefox.png", "Kaxantej ba’ax k’a’anan tech bey xan óoken Red Internet yéetel FIREFOX", "fiefox", active +"\\speech\\myn_MX\\firefox-maya_myn_MX.ogg", 2);
//        b.agregarBoton(active +"\\icons\\libreoffice.png", "Meet a ts’íibil ju’uno’ob yéetel LIBREOFFICE", "libreoffice", active +"\\speech\\myn_MX\\libreoffice_myn_MX.ogg", 2);
//        b.agregarBoton(active +"\\icons\\gpicview.png", "Ts’ool a wóochelo’ob yéetel GPICVIEW", "gpicview", active +"\\speech\\myn_MX\\gpicview_myn_MX.ogg", 2);
         b.agregarBoton(active +"\\icons\\vlc.png", "Il a wil a videos bey xan wu’uy a páaxo’ob yéetel VLC", "vlc", active +"\\speech\\myn_MX\\vlc_myn_MX.ogg", 2);
//        b.agregarBoton(active +"\\icons\\pidgin.png", "Tsikbanen yéetel máaxo’ob uts a biskabaj yéetel PIDGIN", "pidgin", active +"\\speech\\myn_MX\\pidgin_myn_MX.ogg", 2);
//        b.agregarBoton(active +"\\icons\\okular.png", "Xook je’e ba’axak ju’unilo’ob yéetel OKULAR", "okular", active +"\\speech\\myn_MX\\okular_myn_MX.ogg", 2);
//        b.agregarBoton(active +"\\icons\\transmission.png", "E’es a woochelo’ob bey xan jejeláas ba’alob yéetel TRANSMISSION", "transmission", active +"\\speech\\myn_MX\\transmission_myn_MX.ogg", 2);
//        b.agregarBoton(active +"\\icons\\brasero.png", "Meet a CDs bey xan a DVDs yéetel BRASERO", "brasero", active +"\\speech\\myn_MX\\brasero_myn_MX.ogg", 2);
//        b.agregarBoton(active +"\\icons\\cheese.png", "Ch’a’a woochelo’ob bey xan meet videos yéetel a cámara Web", "cheese", active +"\\speech\\myn_MX\\cheese_myn_MX.ogg", 2);
        b.agregarBoton(active +"\\icons\\audacity.png", "Grabarte t’aano’ob waa juumo’ob bey xan meet k’eexo’ob ti’ a grabaciones yéetel AUDACITY", "audacity", active +"\\speech\\myn_MX\\audacity_myn_MX.ogg", 2);
//        b.agregarBoton(active +"\\icons\\openshot.png", "Edita tus grabaciones de vídeo con OPENSHOT.", "openshot", active +"\\speech\\myn_MX\\openshot_myn_MX.ogg", 2);
//        b.agregarBoton(active +"\\icons\\kmag.png", "Meet u nojochtal le kúuchil ku chikpajal yéetel KMAG", "kmag", active +"\\speech\\myn_MX\\kmag_myn_MX.ogg", 2);
//        b.agregarBoton(active +"\\icons\\onboard.png", "Meet u chikpajal tu’ux ku beytal a ts’íib te’ kuuchila’", "onboard", active +"\\speech\\myn_MX\\onboard_myn_MX.ogg", 2);
//        b.agregarBoton(active +"\\icons\\eviacam.png", "Yéetel a poole’  péeks le ch’o’ yéetel EVIACAM", "enviacam", active +"\\speech\\myn_MX\\enviacam_myn_MX.ogg", 2);
//        b.agregarBoton(active +"\\icons\\xrandr.png", "Ke’ex bix a wilik le nu’ukula’ waa le kúuchila’", "mate-display-properties", active +"\\speech\\es_MX\\xrandr_es_MX.ogg", 2);
//        b.agregarBoton(active +"\\icons\\terminal.png", "Wáach’ jump’éel TERMINAL tu’ux ka ts’íib ti’al a wa’alik ba’ax a k’aat ka u beete u nu’ukulil a meyaj", "exterm", active +"\\speech\\myn_MX\\xterm_myn_MX.ogg", 2);
        b.agregarBoton(active +"\\icons\\icon.png", "HELIOX GNU/LINUX jump’éel sistema operativo xma’ bo’olbil tia’al u táan óolta’al jejeláas máako’ob yéetel jejeláas miatsilo’ob.", active +"http://www.proyectoheliox.org", active +"\\speech\\myn_MX\\ProyectoHeliox_myn_MX.ogg", 1);
         
//Nahuatl
        b.agregarBoton(active +"\\icons\\ley.png", "Xikixpowa in Tlanahuatilli itechpa imintlahtolmelauhcayo in macehualaltepemeh", active +"\\material\\ley-es.pdf", active +"\\speech\\nah_MX\\ley_nah_MX.ogg", 3);
        b.agregarBoton(active +"\\icons\\inali.png", "Xikita imasewalajtolpowalis Mexijko totlalnantsin ", "http://inali.gob.mx/clin-inali/", active +"\\speech\\nah_MX\\catalogo_nah_MX.ogg", 3);
        b.agregarBoton(active +"\\icons\\10cosas.png", "Xikixpowa in “10 tlamantli itechpa totlajtol in tlen nochtin tlajtojke moneki kimatiske”", active +"\\material\\10cosas-nah.pdf", active+"\\speech\\nah_MX\\10cosas_nah_MX.ogg", 3);
        b.agregarBoton(active +"\\icons\\enadis.png", "Xikixpowa in Tlajtlanilistli ipan nochi totlalnantsin itechpa ixtlaweli ipan Mexijko 2012", active +"\\material\\enadis-nah.pdf", active +"\\speech\\nah_MX\\encuesta2012_nah_MX.ogg", 3);
        b.agregarBoton(active +"\\icons\\videos.png", "Xiktlapowa nikan ik tikitas video ika nawatl", active +"\\material\\VideosEnIdiomas", active +"\\speech\\nah_MX\\carpeta_nah_MX.ogg", 3);
        b.agregarBoton(active +"\\icons\\inali.png", "Xikixpowa iamaixko web in Instituto de Lenguas Indigenas", "http://inali.gob.mx", active +"\\speech\\nah_MX\\inali_nah_MX.ogg", 3);
        b.agregarBoton(active +"\\icons\\compartiendosaberes.png", "Xikixpowa iamaixko web Tlamatilismako", "http://www.compartiendo-saberes.org/",active +"\\speech\\nah_MX\\firefox-nahuatl http_--www.compartiendosaberes.org_nah_MX.ogg", 3);
        b.agregarBoton(active +"\\icons\\guardavoces.png", "Xikitta in kokonej iminamaixko tlen itoka “Los Guardavoces”", "http://site.inali.gob.mx/guarda_voces/", active +"\\speech\\nah_MX\\guardavoces_nah_MX.ogg", 3);
        b.agregarBoton(active +"\\icons\\firefox.png", "Xiktemowa itlaj wan xitlatejtemowa internet itechkopa FIREFOX ", "firefox", active +"\\speech\\nah_MX\\firefox-nahuatl_nah_MX.ogg", 3);
//        b.agregarBoton(active +"\\icons\\libreoffice.png", "Xikijkuilo moamauj itechkopa LIBREOFFICE", "libreoffice", active +"\\speech\\nah_MX\\libreoffice_nah_MX.ogg", 3);
//        b.agregarBoton(active +"\\icons\\gpicview.png", "Xiktekpana nochi motlaixkopinal itechkopa GPICVIEW", "gpicview", active +"\\speech\\nah_MX\\gpicview_nah_MX.ogg", 3);
        b.agregarBoton(active +"\\icons\\vlc.png", "Xikitta movideo xijkaki motlatsotsonal itechkopa VLC", "vlc", active +"\\speech\\nah_MX\\vlc_nah_MX.ogg", 3);
//        b.agregarBoton(active +"\\icons\\pidgin.png", "Ximotlapowi inwan moteixmatkawan itechkopa PIDGIN", "pidgin", active +"\\speech\\nah_MX\\pidgin_nah_MX.ogg", 3);
//        b.agregarBoton(active +"\\icons\\okular.png", "Xikixpowa nochi tlaman amatl itechkopa OKULAR", "okular", active +"\\speech\\nah_MX\\okular_nah_MX.ogg", 3);
//        b.agregarBoton(active +"\\icons\\transmission.png", "Xiktitlani moamauj itechkopa TRANSMISSION ", "transmission", active +"\\speech\\nah_MX\\transmission_nah_MX.ogg", 3);
//        b.agregarBoton(active +"\\icons\\brasero.png", "Xikpiya moCD noso moDVD itechkopa BRASERO", "brasero", active +"\\speech\\nah_MX\\brasero_nah_MX.ogg", 3);
//        b.agregarBoton(active +"\\icons\\cheese.png", "Xitlaixkopina noso xikchiwa se video itechkopa mocamara Web", "cheese", active +"\\speech\\nah_MX\\cheese_nah_MX.ogg", 3);
        b.agregarBoton(active +"\\icons\\audacity.png", "Xikpiya motoski motlatsotsonal wan xikyektlali itechkopa ", "audacity", active +"\\speech\\nah_MX\\audacity_nah_MX.ogg", 3);
//        b.agregarBoton(active +"\\icons\\openshot.png", "Xikyektlali movideo itechkopa OPENSHOT", "openshot", active +"\\speech\\nah_MX\\openshot_nah_MX.ogg", 3);
//        b.agregarBoton(active +"\\icons\\kmag.png", "Meet u nojochtal le kúuchil ku chikpajal yéetel KMAG", "kmag", active +"\\speech\\nah_MX\\kmag_nah_MX.ogg", 2);
//        b.agregarBoton(active +"\\icons\\onboard.png", "Xikmajpilwiteki se tecla ipan amaixko", "onboard", active +"\\speech\\nah_MX\\onboard_nah_MX.ogg", 3);
//        b.agregarBoton(active +"\\icons\\eviacam.png", "Xikolini in kimichin ika motsontekon itechkopa EVIACAM", "enviacam", active +"\\speech\\nah_MX\\eviacam_nah_MX.ogg", 3);
//        b.agregarBoton(active +"\\icons\\xrandr.png", "Xikpatlawa noso xiktsininti in amaixko", "mate-display-properties", active +"\\speech\\nah_MX\\xrandr_nah_MX.ogg", 3);
//        b.agregarBoton(active +"\\icons\\terminal.png", "Xiktlapowa se TERMINAL ijkon tikyakanas mosistema itechkopa lineas de comandos", "exterm", active +"\\speech\\nah_MX\\xterm_nah_MX.ogg", 3);
b.agregarBoton(active +"\\icons\\icon.png", "HELIOX yejwa se sistema operativo tlen kipiya inelwayo ipan software libre, ochiwalok ik motekiujtis ipan totekiuj wan toyujkatilis.  ", active +"http://www.proyectoheliox.org", active +"\\speech\\nah_MX\\ProyectoHeliox_nah_MX.ogg", 1);
    
        //Quechua
        b.agregarBoton(active +"\\icons\\ley.png", "Maskary llapan Kamachiy Derechos Lingüísticos de los pueblos Indígenas  nisqata", active +"\\material\\ley-es.pdf", active +"\\speech\\que_PE\\ley_que_PE.ogg", 4);
        b.agregarBoton(active +"\\icons\\inali.png", "Maskary qhelqa t'aqhepi Lenguas Indigenas Nacionales nisqapi", "http://inali.gob.mx/clin-inali/", active +"\\speech\\que_PE\\catalogo_que_PE.ogg", 4);
        b.agregarBoton(active +"\\icons\\10cosas.png", "Ñauwinchay qhelqata willakunmin “10 yachaykuna reqsirinachis kay rimariyninchismanta”", active +"\\material\\10cosas-es.pdf", active+"\\speech\\que_PE\\10cosas_que_PE.ogg", 4);
        b.agregarBoton(active +"\\icons\\enadis.png", "Q'awary Encuesta Nacional de Discriminacion 2012 nisqanta", active +"\\material\\enadis-es.pdf", active +"\\speech\\que_PE\\encuesta2012_que_PE.ogg", 4);
        b.agregarBoton(active +"\\icons\\videos.png", "Haykuy t'aqheman Videos nisqata ñawinchanaquipaq Castilla simipi", active +"\\material\\VideosEnIdiomas", active +"\\speech\\que_PE\\carpeta_que_PE.ogg", 4);
        b.agregarBoton(active +"\\icons\\inali.png", "Accede al sitio web del Instituto Nacional de Lenguas Indígenas", "http://inali.gob.mx", active +"\\speech\\que_PE\\inali_que_PE.ogg", 4);
        b.agregarBoton(active +"\\icons\\compartiendosaberes.png", "Haykuy kay Sitio Web Yachayninchista reqsirinanchipaq ", "http://www.compartiendo-saberes.org/",active +"\\speech\\que_PE\\firefox http_--www.compartiendosaberes.org_que_PE", 4);
        b.agregarBoton(active +"\\icons\\guardavoces.png", "Hawariy kay enlace wawakunapaq “Los Guardavoces”", "http://site.inali.gob.mx/guarda_voces/", active +"\\speech\\que_PE\\guardavoces_que_PE.ogg", 4);
//        b.agregarBoton(active +"\\icons\\firefox.png", "Masqary willakuykunada hinataq taqwiry kay red Internet FIREFOX niqapi", "firefox", active +"\\speech\\que_PE\\firefox_que_PE.ogg", 4);
//        b.agregarBoton(active +"\\icons\\libreoffice.png", "kellqay documentoykita LIBREOFFICE nisqapi", "libreoffice", active +"\\speech\\que_PE\\libreoffice_que_PE.ogg", 4);
//        b.agregarBoton(active +"\\icons\\gpicview.png", "Churay fotoykikunata GPICVIEW nisqapi", "gpicview", active +"\\speech\\que_PE\\gpicview_que_PE.ogg", 4);
        b.agregarBoton(active +"\\icons\\vlc.png", "Videokikunata purichiy hinataq Música nisqata VLC nisqapi", "vlc", active +"\\speech\\que_PE\\vlc_que_PE.ogg", 4);
//        b.agregarBoton(active +"\\icons\\pidgin.png", "Rimay reqsisqhakikunawan PIDGIN nisqapi", "pidgin", active +"\\speech\\que_PE\\pidgin_que_PE.ogg", 4);
//        b.agregarBoton(active +"\\icons\\okular.png", "ñawinchay imaymana documentokunata OKULAR nisqapi", "okular", active +"\\speech\\que_PE\\okular_que_PE.ogg", 4);
//        b.agregarBoton(active +"\\icons\\transmission.png", "willay archivoykikunata TRANSMISSION nisqawan", "transmission", active +"\\speech\\que_PE\\transmission_que_PE.ogg", 4);
//        b.agregarBoton(active +"\\icons\\brasero.png", "Waqhaychay CD nisqakunata otaqchu DVD nisqakunata BRASERO nisqawan", "brasero", active +"\\speech\\que_PE\\brasero_que_PE.ogg", 4);
//        b.agregarBoton(active +"\\icons\\cheese.png", "Waqachay Qh'awanakunata hinataq videos nisqacunata camara web nisqapi", "cheese", active +"\\speech\\que_PE\\cheese_que_PE.ogg", 4);
        b.agregarBoton(active +"\\icons\\audacity.png", "waqachay sonido nisqata hinataq munasqaykiman t'iqray waqaychasqakikunata AUDACITY nisqawan", "audacity", active +"\\speech\\que_PE\\audacity_que_PE.ogg", 4);
//        b.agregarBoton(active +"\\icons\\openshot.png", "munasqaykiman t'iqray video waqaychasqaykita OPENSHOT nisqawan", "openshot", active +"\\speech\\que_PE\\openshot_que_PE.ogg", 4);
//        b.agregarBoton(active +"\\icons\\kmag.png", "hatuman tukuchiy panatalla nisqata KMAG nisqawan", "kmag", active +"\\speech\\que_PE\\kmag_que_PE.ogg", 2);
//        b.agregarBoton(active +"\\icons\\onboard.png", "ocurichiy teclado nisqata pantalla nisqapi", "onboard", active +"\\speech\\que_PE\\onboard_que_PE.ogg", 4);
 //       b.agregarBoton(active +"\\icons\\eviacam.png", "cuyuchy huqochata umaykiwan EVIACAM nisqawan", "enviacam", active +"\\speech\\que_PE\\enviacam_que_PE.ogg", 4);
//        b.agregarBoton(active +"\\icons\\xrandr.png", "tupachiy monitor niskaqta otacchu pantalla nisqata munayniyquiman", "mate-display-properties", active +"\\speech\\que_PE\\xrandr_que_PE.ogg", 4);
//        b.agregarBoton(active +"\\icons\\terminal.png", "kicharey uq TERMINAL nisqata alliman puririchinaykipaq kay sistema nisqata línea de comandos nisqata", "exterm", active +"\\speech\\que_PE\\xterm_que_PE.ogg", 4);
        
        //Mixe 
          b.agregarBoton(active + "\\icons\\ley.png", "Ejx ja ana’amën te’ep yää Nëwiiny may ää ayuujk nyëkuwanpy", active + "\\material\\ley-es.pdf", active + "\\speech\\myg_MX\\ley_mig_MX.ogg", 5);
        b.agregarBoton(active + "\\icons\\inali.png", "Ejx ja tëkatsyety ää ayuujk mëte’ep yää Nëwemp yakkäjpxp ", "http://inali.gob.mx/clin-inali/", active + "\\speech\\myg_MX\\catalogo_mig_MX.ogg", 5);
        b.agregarBoton(active + "\\icons\\10cosas.png", " Käjpx yë neky mëte’ep nyëkajpxpy ja mäjk jënmä’äny mëte’ep yë jä’äy mëte’ep ayuujk kyajpxpy jëkeexy nyëjä’wëp.", active + "\\material\\10cosas-es.pdf", active + "\\speech\\myg_MX\\10cosas_mig_MX.ogg", 5);
        b.agregarBoton(active + "\\icons\\enadis.png", "Ejx xë’n ojts ja jëmëjt 2012 ja jä’äy jyënmä’äny tpëtä’äkt yää Nëwiiny xë’n atom nnay’ëjxwijtsyëm nnay’apejxyëm", active + "\\material\\enadis-es.pdf", active + "\\speech\\myg_MX\\encuesta2012_mig_MX.ogg", 5);
        b.agregarBoton(active + "\\icons\\videos.png", "Tëjk yäjp mää ja pi’kxyën mää myiny ja ijxy ja jäw amaxän", active + "\\material\\VideosEnIdiomas", active + "\\speech\\myg_MX\\carpeta_mig_MX.ogg", 5);
        b.agregarBoton(active + "\\icons\\inali.png", "Tëk yäjp mää ja ää ayuujk jyëntijpy", "http://inali.gob.mx", active + "\\speech\\myg_MX\\inali_mig_MX.ogg", 5);
        b.agregarBoton(active + "\\icons\\compartiendosaberes.png", "Haykuy kay Sitio Web Yachayninchista reqsirinanchipaq ", "http://www.compartiendo-saberes.org/", active + "\\speech\\myg_MX\\firefox http_--www.compartiendosaberes.org_mig_MX", 5);
//        b.agregarBoton(active + "\\icons\\guardavoces.png", "Ejx yäjp mää ja mutsk anä’äjk jyënmä’äny yakpëjkta’akyën Los Guardavoces jyëntunp”", "http://site.inali.gob.mx/guarda_voces/", active + "\\speech\\myg_MX\\guardavoces_mig_MX.ogg", 5);
//        b.agregarBoton(active +"\\icons\\firefox.png", "Ejxtä’äy jëts wets may yäjp internetjotp mëët Firefox", "firefox", active +"\\speech\\myg_MX\\firefox_mig_MX.ogg", 5);
//        b.agregarBoton(active +"\\icons\\libreoffice.png", "Jä’äy ja mneky mëët ja libreoffice", "libreoffice", active +"\\speech\\myg_MX\\libreoffice_mig_MX.ogg", 5);
//        b.agregarBoton(active +"\\icons\\gpicview.png", "Tanëpëktääk xën yë m’akojnäx xpëjkë’ëkä’än mëët yë Gpicview", "gpicview", active +"\\speech\\myg_MX\\gpicview_mig_MX.ogg", 5);
        b.agregarBoton(active + "\\icons\\vlc.png", "Yaktepyëk yë m’ijxy mjäw jets yë msoon mëët VLC", "vlc", active + "\\speech\\myg_MX\\vlc_mig_MX.ogg", 5);
//        b.agregarBoton(active +"\\icons\\pidgin.png", "Rimay reqsisqhakikunawan PIDGIN nisqapi", "pidgin", active +"\\speech\\myg_MX\\pidgin_mig_MX.ogg", 5);
//        b.agregarBoton(active +"\\icons\\okular.png", "Ejx eymëte’ep neky mëët ja Okular", "okular", active +"\\speech\\myg_MX\\okular_mig_MX.ogg", 5);
//        b.agregarBoton(active +"\\icons\\transmission.png", "Yakwä’kx yë mpëkta’aky mëët Transmission", "transmission", active +"\\speech\\myg_MX\\transmission_mig_MX.ogg", 5);
//        b.agregarBoton(active +"\\icons\\brasero.png", "Aknëkojtu’ut yë CD jets DVD mëët Brasero", "brasero", active +"\\speech\\myg_MX\\brasero_mig_MX.ogg", 5);
//        b.agregarBoton(active +"\\icons\\cheese.png", "Aknëkojtu’ut  ja m’akojnäx jëts ja m’ijxy mjäw mëët ja m’ejxpajtën", "cheese", active +"\\speech\\myg_MX\\cheese_mig_MX.ogg", 5);
        b.agregarBoton(active + "\\icons\\audacity.png", "Aknëkojtu’ut ja msoon jët ak’a’ey ja m’ijxy mjäw mëët Audacity", "audacity", active + "\\speech\\myg_MX\\audacity_mig_MX.ogg", 5);
//        b.agregarBoton(active +"\\icons\\openshot.png", "Yak’a’ey yë m’ijxy mjäw mëët Openshot", "openshot", active +"\\speech\\myg_MX\\openshot_mig_MX.ogg", 5);
//        b.agregarBoton(active +"\\icons\\kmag.png", "Yakakmëj yë m’ejxpajtën mëët kmag", "kmag", active +"\\speech\\myg_MX\\kmag_mig_MX.ogg", 5);
//        b.agregarBoton(active +"\\icons\\onboard.png", "Yakpëtsëm mëët yë m’ejxpajtën tu’uk japyajt", "onboard", active +"\\speech\\myg_MX\\onboard_mig_MX.ogg", 5);
//       b.agregarBoton(active + "\\icons\\eviacam.png", "Akjëtet yë panpajt mëët yë mkëpäjk mëët yë Eviacam", "enviacam", active + "\\speech\\myg_MX\\enviacam_mig_MX.ogg", 5);
//        b.agregarBoton(active +"\\icons\\xrandr.png", "tupachiy monitor niskaqta otacchu pantalla nisqata munayniyquiman", "mate-display-properties", active +"\\speech\\myg_MX\\xrandr_mig_MX.ogg", );
//        b.agregarBoton(active +"\\icons\\terminal.png", "Yak’awä’äts tu’uk terminal jëts jajp xmë’atë’ëtst ja mtunpajt mää jatu’uk ää ayuujkën", "exterm", active +"\\speech\\myg_MX\\xterm_mig_MX.ogg", 5);




        System.out.println("Agregados Botones");

    }

}
