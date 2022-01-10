package com.example.pdfGenerator.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import org.springframework.stereotype.Service;

@Service
public class pdfGeneratorService {
    public void export(HttpServletResponse response) throws DocumentException, IOException{
        com.itextpdf.text.Document tokenDoc = new com.itextpdf.text.Document(PageSize.A4);
        PdfWriter.getInstance(tokenDoc, response.getOutputStream());

        tokenDoc.open();
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontTitle.setSize(18);

        Paragraph title = new Paragraph("Using Spring Boot to generate PDF", fontTitle);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        
        Font fontParagraph = FontFactory.getFont(FontFactory.TIMES);
        fontParagraph.setSize(12);

        Paragraph paragraph = new Paragraph("There were about twenty people on the dam. Most of them were simply walking and getting exercise. There were a few who were fishing. There was a family who had laid down a blanket and they were having a picnic. It was like this most days and nothing seemed out of the ordinary. The problem was that nobody noticed the water leaking through the dam wall.", fontParagraph);
        paragraph.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph.setPaddingTop(25);

        Paragraph between1 = new Paragraph("\n", fontParagraph);

        Paragraph paragraph2 = new Paragraph("Josh had spent year and year accumulating the information. He knew it inside out and if there was ever anyone looking for an expert in the field, Josh would be the one to call. The problem was that there was nobody interested in the information besides him and he knew it. Years of information painstakingly memorized and sorted with not a sole giving even an ounce of interest in the topic.", fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph2.setPaddingTop(25);


        Paragraph paragraph3 = new Paragraph("Peter always saw the world in black and white. There were two choices for every situation and you had to choose one of them. It was therefore terribly uncomfortable for him to spend time with Ashley. She saw the world in shades of gray with hundreds of choices to choose from in every situation.", fontParagraph);
        paragraph3.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph3.setPaddingTop(25);

        Paragraph paragraph4 = new Paragraph("Mary had to make a decision and she knew that whatever decision she made, it would upset someone. It seemed like such a silly reason for people to get upset but she knew the minute that she began to consider doing it that there was no way everyone in her life would be pleased with what she ultimately decided to do. It was simply a question of who she would rather displease most. While this had always been her parents, and especially her mom, in the past that she tried to keep from upsetting, she decided that this time the person she was going to please the most with her decision was herself.", fontParagraph);
        paragraph4.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph4.setPaddingTop(25);

        tokenDoc.add(title);
        tokenDoc.add(between1);
        tokenDoc.add(paragraph);
        tokenDoc.add(between1);
        tokenDoc.add(paragraph2);
        tokenDoc.add(between1);
        tokenDoc.add(paragraph3);
        tokenDoc.add(between1);
        tokenDoc.add(paragraph4);
        tokenDoc.close();

    }
}
