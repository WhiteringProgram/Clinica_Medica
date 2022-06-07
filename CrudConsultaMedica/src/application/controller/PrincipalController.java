package application.controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import application.modelo.Consulta;

import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;

import javafx.scene.Scene;




public class PrincipalController {
	@FXML
	private TextField tfCodigoConsulta;
	@FXML
	private TextField tfNomeConsulta;
	@FXML
	private TextField tfDataConsulta;
	@FXML
	private TextField tfIDExame;
	@FXML
	private TextField tfIDMedico;
	@FXML
	private Button btnBuscarConsulta;
	@FXML
	private Button btnInserirConsulta;
	@FXML
	private Button btnAtualizarConsulta;
	@FXML
	private Button btnExcluirConsulta;
	@FXML
	private Button btnListarConsulta;
	@FXML
	private TextArea taListaConsultas;
	@FXML
	private Button btnCopiaConsulta;
	
	

	// Event Listener on TextField[#tfCodigoConsulta].onAction
	@FXML
	public void acaoConsulta(ActionEvent event) {
		String cmd = event.getSource().toString();
		ConsultaController control = new ConsultaController(tfCodigoConsulta, tfNomeConsulta, tfDataConsulta,
				           tfIDExame, tfIDMedico, taListaConsultas);	
		
		if ((cmd.contains("Inserir")|| cmd.contains("Atualizar"))
		&& (tfCodigoConsulta.getText().isEmpty())
		|| tfNomeConsulta.getText().isEmpty()
		|| tfDataConsulta.getText().isEmpty()
		|| tfIDExame.getText().isEmpty()
		|| tfIDMedico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
		} else {
			if (cmd.contains("Excluir") || cmd.contains("Buscar") || cmd.contains("tfCodigoConsulta")
				&& tfCodigoConsulta.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o código", "ERRO", JOptionPane.ERROR_MESSAGE);
				} else
					try {
						if(cmd.contains("Listar")){
						control.buscarConsultas();		
					} else {
						Consulta c = new Consulta();
						c.setConsID(Integer.parseInt(tfCodigoConsulta.getText()));
						c.setConsNome(tfNomeConsulta.getText());
						c.setConsIdExame(Integer.parseInt(tfIDExame.getText()));
						c.setConsIdMedico(Integer.parseInt(tfIDMedico.getText()));
						if (cmd.contains("Inserir")) {
							control.inserirConsulta(c);
						} else if (cmd.contains("Atualizar")) {
							control.atualizarConsulta(c);
						} else if (cmd.contains("Excluir")) {
							control.excluirConsulta(c);
						} else if (cmd.contains("Buscar") || cmd.contains("tfCodigoConsulta")) {
							control.buscarConsulta(c);
						}
					}
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		}
	}
	
	@FXML
	public void copiaConsulta(ActionEvent event) {
		if (tfCodigoConsulta.getText().isEmpty() || tfNomeConsulta.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
		} else {
			tfCodigoConsulta.setText(tfCodigoConsulta.getText());
			tfNomeConsulta.setText(tfNomeConsulta.getText());
		}
		
	}
}
