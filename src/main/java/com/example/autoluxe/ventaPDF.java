package com.example.autoluxe;

import ClasesObjetos.BDautoluxe;
import ClasesObjetos.Clientes;
import ClasesObjetos.Empleados;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ventaPDF
{
    private String nombreArchivoPDF="";
    private String fechaActual="";
    private String nombreCliente;
    private String telefonoCliente;
    private String dniCliente;
    private String nombreEmpleado;
    private String correoEmpleado;
    //Método para obtener los datos del cliente
    public void DatosCliente(String dni)
    {
        Clientes cliente= BDautoluxe.obtenerClienteDNI(dni);
        nombreCliente=cliente.getNombre();
        dniCliente=cliente.getDNI();
        telefonoCliente=cliente.getTelefono();
    }
    //Método para obtener los datos del empleado
    public void DatosEmpleado(String dni)
    {
        Empleados empleado= BDautoluxe.obtenerEmpleadoDNI(dni);
        nombreEmpleado=empleado.getNombre();
        correoEmpleado=empleado.getDNI();
    }
    //Método para generar la factura de venta
    public void generarFactura()
    {
        try {
            //Establecer fecha actual
            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            //Cambiar el formato de la fecha de / a _
            String fechaFormateada = "";
            for (int i = 0; i < fechaActual.length(); i++) {
                if (fechaFormateada.charAt(i) == '/') {
                    fechaFormateada = fechaActual.replace("/", "_");
                }
            }
            //Establecer nombre de la factura
            nombreArchivoPDF = "Factura_" + nombreCliente + "_" + fechaFormateada + ".pdf";
            //Guardar las facturas
            FileOutputStream archivo;
            File file = new File("src/facturas_pdf/" + nombreArchivoPDF);
            archivo = new FileOutputStream(file);
            //Generar un nuevo documento
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            //ENCABEZADO
            Image img = Image.getInstance("src/main/resources/imagenes/LogoAutoLuxe.png");
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE);
            fecha.add("Factura: 001 \nFecha:" + fechaActual + "\n\n");
            PdfPTable encabezado = new PdfPTable(4);
            encabezado.setWidthPercentage(100);
            encabezado.getDefaultCell().setBorder(0);
            float columnaEncabezado[] = new float[]{20f, 30f, 70f, 40f};
            encabezado.setWidths(columnaEncabezado);
            encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            encabezado.addCell(img);
            String ruc = "00901289367";
            String nombre = "AutoLuxe S.A.";
            String telefono = "666 66 66 66";
            String direccion = "C/Los Marines,Roquetas de Mar,Almería";
            encabezado.addCell("");
            encabezado.addCell("RUC:" + ruc + "\nNOMBRE:" + nombre + "\nTELÉFONO:" + telefono + "\nDIRECCIÓN:" + direccion);
            encabezado.addCell(fecha);
            //DATOS DEL CLIENTE
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);
            cliente.add("Datos del cliente: " + "\n\n");
            doc.add(cliente);
            PdfPTable tablaCliente = new PdfPTable(3);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0);
            float columnaCliente[] = new float[]{25f, 45f, 45f};
            tablaCliente.setWidths(columnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("DNI:", negrita));
            PdfPCell cliente2 = new PdfPCell(new Phrase("NOMBRE:", negrita));
            PdfPCell cliente3 = new PdfPCell(new Phrase("TELÉFONO:", negrita));
            cliente1.setBorder(0);
            cliente2.setBorder(0);
            cliente3.setBorder(0);
            tablaCliente.addCell(cliente1);
            tablaCliente.addCell(cliente2);
            tablaCliente.addCell(cliente3);
            tablaCliente.addCell(dniCliente);
            tablaCliente.addCell(nombreCliente);
            tablaCliente.addCell(telefonoCliente);
            doc.add(tablaCliente);
            //ESPACIO EN BLANCO
            Paragraph espacio=new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);
            //DATOS EMPLEADO
            Paragraph empleado = new Paragraph();
            empleado.add(Chunk.NEWLINE);
            empleado.add("Datos del empleado: " + "\n\n");
            doc.add(empleado);
            PdfPTable tablaEmpleado = new PdfPTable(2);
            tablaEmpleado.setWidthPercentage(100);
            tablaEmpleado.getDefaultCell().setBorder(0);
            float columnaEmpleado[] = new float[]{45f, 70f};
            tablaEmpleado.setWidths(columnaEmpleado);
            tablaEmpleado.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell empleado1 = new PdfPCell(new Phrase("NOMBRE:", negrita));
            PdfPCell empleado2 = new PdfPCell(new Phrase("CORREO:", negrita));
            empleado1.setBorder(0);
            empleado2.setBorder(0);
            tablaCliente.addCell(empleado1);
            tablaCliente.addCell(empleado2);
            tablaCliente.addCell(nombreEmpleado);
            tablaCliente.addCell(correoEmpleado);
            doc.add(tablaEmpleado);
            //ESPACIO EN BLANCO
            doc.add(espacio);
            //AGREGAR PRODUCTOS
            PdfPTable tablaProducto =new PdfPTable(4);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);
            float columnaProducto[] = new float[]{15f, 50f, 15f,20f};
            tablaProducto.setWidths(columnaProducto);
            tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1 = new PdfPCell(new Phrase("CANTIDAD:", negrita));
            PdfPCell producto2 = new PdfPCell(new Phrase("DESCRIPCIÓN:", negrita));
            PdfPCell producto3 = new PdfPCell(new Phrase("PRECIO UNITARIO::", negrita));
            PdfPCell producto4 = new PdfPCell(new Phrase("PRECIO TOTAL:", negrita));
            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);
            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tablaProducto.addCell(producto1);
            tablaProducto.addCell(producto2);
            tablaProducto.addCell(producto3);
            tablaProducto.addCell(producto4);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
