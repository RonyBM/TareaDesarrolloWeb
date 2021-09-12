package com.desarrolloweb.spring.app.view.pdf;

import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.desarrolloweb.spring.app.entities.Proveedores;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("detalle-proveedor-form.pdf")
public class ProveedoresPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		document.setPageSize(PageSize.LETTER.rotate());
		document.setMargins(-20,-20,40,20);
		document.open();
		
		PdfPTable tablatitulo = new PdfPTable(1);
		PdfPCell celda = null;
		
		com.lowagie.text.Font fuenteTitulo = FontFactory.getFont("Helvetica",16,Color.BLACK);
		
		
		celda=  new PdfPCell(new Phrase("Listado Generación de clientes", fuenteTitulo ));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(2,251,225));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(30);
		
		tablatitulo.addCell(celda);
		tablatitulo.setSpacingAfter(30);
		
		Proveedores proveedor = (Proveedores) model.get("proveedor");
		
		PdfPTable tabla = new PdfPTable(5);
		tabla.setSpacingAfter(20);
		
		tabla.addCell(proveedor.getNombre());
		tabla.addCell(proveedor.getDireccion());
		tabla.addCell(proveedor.getEmail());
		tabla.addCell(proveedor.getTelefono());
		
		document.add(tablatitulo);
		document.add(tabla);
	}

}
