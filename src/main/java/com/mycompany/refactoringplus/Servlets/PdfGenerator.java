package com.mycompany.refactoringplus.Servlets;

import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.ByteArrayOutputStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import com.mycompany.refactoringplus.Classes.*;

public class PdfGenerator {
    
    public static PDDocument document = new PDDocument();
    public static PDPage page = new PDPage(PDRectangle.A4);
    public static float x = 0;
    public static float y = 800;
    public static float contentX = -100;
    public static float contentY = -30;
    private static final float PAGE_HEIGHT = PDRectangle.A4.getHeight();
    public static PDPageContentStream contentStream;
    public static PDPageContentStream contentStream2;

    public static byte[] generatePdf() throws IOException {
        
        
            document.addPage(page);

      
            contentStream = new PDPageContentStream(document, page);
            
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16); // Tamaño de fuente más grande para el título

            // Añadir el título (centrado)
            float titleWidth = PDType1Font.HELVETICA_BOLD.getStringWidth("Reporte Herramienta de Refactorizacion ATI") / 1000 * 16;
            float titleX = (page.getMediaBox().getWidth() - titleWidth) / 2;
            contentStream.newLineAtOffset(titleX, 800);
            contentStream.showText("Reporte Herramienta de Refactorizacion ATI");

            // Continuar con el contenido del informe
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

            // Posición inicial para el contenido de las iteraciones
            
            
            contentStream.newLineAtOffset(contentX, contentY );
            contentStream.showText("");
            
            for(Application a: DataManager.applications){
                y-=35;
                addPage();
                contentStream.newLineAtOffset(0, contentY - 35);
                contentStream.showText(a.getName() );
                y-=35;
                addPage();
                contentStream.newLineAtOffset(30, contentY - 35);
                contentStream.showText("Encargados: ");
                
                contentStream.newLineAtOffset(30, 0);
                contentStream.showText("");
                
                for(Incharge in: a.getIncharge()){
                    y-=35;
                    addPage();
                    contentStream.newLineAtOffset(0, contentY - 35);
                    contentStream.showText(in.getName());
                    
                    
                    
                }
                y-=35;
                addPage();
                contentStream.newLineAtOffset(-30, contentY - 35);
                contentStream.showText("Clases: ");
                
                contentStream.newLineAtOffset(30, 0);
                contentStream.showText("");
                
                for(AppClass appc: DataManager.classes){
                    for(Application app : appc.getApp()){
                        if(app.getName().equals(a.getName())){
                            y-=35;
                            addPage();
                            contentStream.newLineAtOffset(0, contentY - 35);
                            contentStream.showText(appc.getClassName());
                            y-=35;
                            addPage();
                            contentStream.newLineAtOffset(-30, contentY - 35);
                            contentStream.showText("Metodos:");
                            
                            contentStream.newLineAtOffset(30, 0);
                            contentStream.showText("");
                            
                            for(ClassMethod cm: DataManager.methods){
                                if(cm.getAppclass().getClassName().equals(appc.getClassName())){
                                    y-=35;
                                    addPage();
                                    contentStream.newLineAtOffset(0, contentY - 35);
                                    contentStream.showText(cm.getMethodName());
                                    y-=35;
                                    addPage();
                                    contentStream.newLineAtOffset(-30, contentY - 35);
                                    contentStream.showText("Olores:");
                                    
                                    contentStream.newLineAtOffset(30, 0);
                                    contentStream.showText("");
                                    
                                    for(Odor odd : cm.getOddors()){
                                        y-=35;
                                        addPage();
                                        contentStream.newLineAtOffset(0, contentY - 35);
                                        contentStream.showText(odd.getOdorName());
                                        y-=35;
                                        addPage();
                                        contentStream.newLineAtOffset(-30, contentY - 35);
                                        contentStream.showText("Metodos Refactorizacion:");
                                        
                                        contentStream.newLineAtOffset(30, 0);
                                        contentStream.showText("");
                                        
                                        for(RefactoringMethod rm: odd.getRefMethod()){
                                            y-=35;
                                            addPage();
                                            contentStream.newLineAtOffset(0, contentY - 35);
                                            contentStream.showText(rm.getRefactorName());
                                        }
                                        
                                    }
                                    
                                    
                                }
                            }
                        }
                    }
                }
                
                contentStream.newLineAtOffset(-210, 0);
                contentStream.showText("");
            }



        contentStream.endText();
        
        contentStream.close();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.save(baos);
        document.close();

        return baos.toByteArray();
    }
    
    public static void addPage() throws IOException {
        
        if (y < 385) {
            // Cerrar el stream actual si está abierto
            if (contentStream != null) {
                contentStream.endText();
                contentStream.close();
            }

            // Crear una nueva página
            page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // Inicializar el nuevo stream en la nueva página
            contentStream = new PDPageContentStream(document, page);

            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16); // Tamaño de fuente más grande para el título

            // Añadir el título (centrado)
            float titleWidth = PDType1Font.HELVETICA_BOLD.getStringWidth("Reporte Herramienta de Refactorizacion ATI") / 1000 * 16;
            float titleX = (page.getMediaBox().getWidth() - titleWidth) / 2;
            contentStream.newLineAtOffset(titleX, 800);
            contentStream.showText("Reporte Herramienta de Refactorizacion ATI");

            // Continuar con el contenido del informe
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            
            contentStream.newLineAtOffset(contentX, contentY );
            contentStream.showText("");

            x = 0;
            y = 800;
            contentX = -100;
            contentY = -30;
        }
    }


}
