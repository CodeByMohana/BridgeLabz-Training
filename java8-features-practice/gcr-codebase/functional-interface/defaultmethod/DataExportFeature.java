package com.java8practice.functionalinterface.defaultmethod;

interface ReportExporter {
	void exportToCSV();

	void exportToPDF();

	// New feature no implementation needed in existing classes
	default void exportToJson() {
		System.out.println("Exporting report to JSON format");
	}
}

class SalesReport implements ReportExporter {

	@Override
	public void exportToCSV() {
		System.out.println("Exporting sales report to CSV format");
	}

	@Override
	public void exportToPDF() {
		System.out.println("Exporting sales report to PDF format");
	}

}

class FinanaceReport implements ReportExporter {

	@Override
	public void exportToCSV() {
		System.out.println("Exporting finance report to CSV format");
	}

	@Override
	public void exportToPDF() {
		System.out.println("Exporting finance report to PDF format");
	}

	// only if specific implementation is needed
	@Override
	public void exportToJson() {
		System.out.println("Custom JSON export for finance report");
	}

}

public class DataExportFeature {
	public static void main(String[] args) {
		ReportExporter salesReport = new SalesReport();
		salesReport.exportToCSV();
		salesReport.exportToPDF();
		salesReport.exportToJson(); // default method

		System.out.println();

		ReportExporter financeReport = new FinanaceReport();
		financeReport.exportToCSV();
		financeReport.exportToPDF();
		financeReport.exportToJson();
	}

}
