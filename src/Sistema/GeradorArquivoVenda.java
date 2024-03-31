/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

/**
 *
 * @author PC
 */
import Sistema.Venda;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


public class GeradorArquivoVenda {

    public static void gerarPDF(Venda venda) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Venda_" + venda.getIdVenda()+ ".pdf"));
            document.open();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            document.add(new Paragraph("Detalhes da Venda"));
            document.add(new Paragraph("ID da Venda: " + venda.getIdVenda()));
            document.add(new Paragraph("Cliente: " + venda.getClienteIdCliente()));
            document.add(new Paragraph("Data da Venda: " + sdf.format(venda.getData())));
            document.add(new Paragraph("Data do Pagamento: " + sdf.format(venda.getDataPagamento())));
            document.add(new Paragraph("Data de Envio: " + sdf.format(venda.getDataEnvioProduto())));
            document.add(new Paragraph("Valor da Venda: " + venda.getValor()));
            document.add(new Paragraph("Tipo de Pagamento: " + venda.getTipoPagamento()));
            document.add(new Paragraph("Quantidade de Parcelas: " + venda.getQtdParcelas()));
            document.add(new Paragraph("Funcionário: " + venda.getFuncionarioIdFuncionario()));
            document.add(new Paragraph("Produto: " + venda.getProdutoIdProduto()));
            document.add(new Paragraph("Quantidade de Produtos: " + venda.getQtdProduto()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    public static void gerarDOCX(Venda venda) {
        XWPFDocument document = new XWPFDocument();
        try {
            FileOutputStream out = new FileOutputStream("Venda_" + venda.getIdVenda() + ".docx");
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            run.setText("Detalhes da Venda\n");
            run.addBreak();
            run.setText("ID da Venda: " + venda.getIdVenda() + "\n");
            run.setText("Cliente: " + venda.getClienteIdCliente() + "\n");
            run.setText("Data da Venda: " + sdf.format(venda.getData()) + "\n");
            run.setText("Data do Pagamento: " + sdf.format(venda.getDataPagamento()) + "\n");
            run.setText("Data de Envio: " + sdf.format(venda.getDataEnvioProduto()) + "\n");
            run.setText("Valor da Venda: " + venda.getValor() + "\n");
            run.setText("Tipo de Pagamento: " + venda.getTipoPagamento() + "\n");
            run.setText("Quantidade de Parcelas: " + venda.getQtdParcelas() + "\n");
            run.setText("Funcionário: " + venda.getFuncionarioIdFuncionario() + "\n");
            run.setText("Produto: " + venda.getProdutoIdProduto() + "\n");
            run.setText("Quantidade de Produtos: " + venda.getQtdProduto() + "\n");
            document.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
