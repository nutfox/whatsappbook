package de.sf.whatsappbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		String sourceFileName = "./target/jasper/jasper_report_template.jasper";
		String printFileName = null;
		DataBeanList DataBeanList = new DataBeanList();
		ArrayList<DataBean> dataList = DataBeanList.getDataBeanList();
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
				dataList);

		Map<String, Object> parameters = new HashMap<String, Object>();
		try {
			printFileName = JasperFillManager.fillReportToFile(sourceFileName,
					parameters, beanColDataSource);
			if (printFileName != null) {
				JasperExportManager.exportReportToPdfFile(printFileName,
						args[0]);
			}
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
}
