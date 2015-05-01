package com.leo.itext.example01;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class DocumentExample {

    public static void main(String[] args) {

    Document document = new Document();

        try {
            PdfWriter.getInstance(document,
                new FileOutputStream("Phrase2.pdf"));

            document.open();
            Chunk chunk = new Chunk("This is a sentence ");

            Phrase phrase = new Phrase(50);

            phrase.add(chunk);
            phrase.add(chunk);
            phrase.add(chunk);
            phrase.add(chunk);
            phrase.add(chunk);
            phrase.add(chunk);

            document.add(phrase);
            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}