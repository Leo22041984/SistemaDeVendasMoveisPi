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

    public static void gerarPDF(Venda venda, Cliente cliente) {
        Document document = new Document();
        try {
            SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String timestamp = timestampFormat.format(new Date());
            PdfWriter.getInstance(document, new FileOutputStream("Venda_" + venda.getIdVenda() + "_" + timestamp + ".pdf"));
            document.open();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            document.add(new Paragraph("Detalhes da Venda"));
            document.add(new Paragraph("ID da Venda: " + venda.getIdVenda()));
            document.add(new Paragraph("Cliente: " + cliente.getNome()));
            document.add(new Paragraph("Endereço: " + cliente.getEndereco()));
            document.add(new Paragraph("Telefone: " + cliente.getTelefone()));
            document.add(new Paragraph("CPF: " + cliente.getCpf()));
            document.add(new Paragraph("Cidade: " + cliente.getCidade()));
            document.add(new Paragraph("UF: " + cliente.getUf()));
            document.add(new Paragraph("Data da Venda: " + sdf.format(venda.getData())));
            document.add(new Paragraph("Data do Pagamento: " + sdf.format(venda.getDataPagamento())));
            document.add(new Paragraph("Data de Envio: " + sdf.format(venda.getDataEnvioProduto())));
            document.add(new Paragraph("Valor da Venda: " + venda.getValor()));
            document.add(new Paragraph("Tipo de Pagamento: " + (venda.getTipoPagamento() != null ? venda.getTipoPagamento() : "N/A")));
            document.add(new Paragraph("Quantidade de Parcelas: " + (venda.getQtdParcelas() != -1 ? venda.getQtdParcelas() : "N/A")));
            document.add(new Paragraph("Funcionário: " + venda.getFuncionarioIdFuncionario()));
            document.add(new Paragraph("Produto: " + venda.getProdutoIdProduto()));
            document.add(new Paragraph("Quantidade de Produtos: " + venda.getQtdProduto()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

// Modifique o método gerarDOCX
    public static void gerarDOCX(Venda venda, Cliente cliente) {
        XWPFDocument document = new XWPFDocument();
        try {
            SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String timestamp = timestampFormat.format(new Date());
            FileOutputStream out = new FileOutputStream("Venda_" + venda.getIdVenda() + "_" + timestamp + ".docx");
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            run.setText("Detalhes da Venda\n");
            run.addBreak();
            run.setText("ID da Venda: " + venda.getIdVenda() + "\n");
            run.setText("Cliente: " + cliente.getNome() + "\n");
            run.setText("Endereço: " + cliente.getEndereco() + "\n");
            run.setText("Telefone: " + cliente.getTelefone() + "\n");
            run.setText("CPF: " + cliente.getCpf() + "\n");
            run.setText("Cidade: " + cliente.getCidade() + "\n");
            run.setText("UF: " + cliente.getUf() + "\n");
            run.setText("Data da Venda: " + sdf.format(venda.getData()) + "\n");
            run.setText("Data do Pagamento: " + sdf.format(venda.getDataPagamento()) + "\n");
            run.setText("Data de Envio: " + sdf.format(venda.getDataEnvioProduto()) + "\n");
            run.setText("Valor da Venda: " + venda.getValor() + "\n");
            run.setText("Tipo de Pagamento: " + (venda.getTipoPagamento() != null ? venda.getTipoPagamento() : "N/A") + "\n");
            run.setText("Quantidade de Parcelas: " + (venda.getQtdParcelas() != -1 ? venda.getQtdParcelas() : "N/A") + "\n");
            run.setText("Funcionário: " + venda.getFuncionarioIdFuncionario() + "\n");
            run.setText("Produto: " + venda.getProdutoIdProduto() + "\n");
            run.setText("Quantidade de Produtos: " + venda.getQtdProduto() + "\n");
            document.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Supondo que você já tenha uma instância de Venda
        Venda venda = new Venda();

        // Obter o ID do cliente associado à venda
        int idCliente = venda.getClienteIdCliente();

        // Instanciar o seu SistemaDAO
        SistemaDAO sistemaDAO = new SistemaDAO();
        sistemaDAO.conectar(); // Conecta ao banco de dados

        // Obter o objeto Cliente correspondente ao ID
        Cliente cliente = sistemaDAO.consultarClientePorId(idCliente);

        sistemaDAO.desconectar(); // Desconecta do banco de dados

        if (cliente != null) {
            // Chamando os métodos gerarPDF ou gerarDOCX passando o cliente como argumento
            gerarPDF(venda, cliente);
            gerarDOCX(venda, cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}
