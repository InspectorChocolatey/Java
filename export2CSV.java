	public static boolean export2CSV(JTable tableToExport,  String pathToExportTo) {
		String holder;
	    try {
	        TableModel model = tableToExport.getModel();
	        FileWriter csv = new FileWriter(new File(pathToExportTo));

	        for (int i = 0; i < model.getColumnCount(); i++) {
	            csv.write(model.getColumnName(i) + ",");
	        }
	        csv.write("\n");
	        for (int i = 0; i < model.getRowCount(); i++) {
	            for (int j = 0; j < model.getColumnCount(); j++) {
	            	try {
	            	holder = model.getValueAt(i, j).toString();
	            	if(holder == null || holder.isEmpty() ) {
	            		csv.write("null" + ",");
	            	} else {
	            		csv.write(model.getValueAt(i, j).toString() + ",");
	            	}
	            	} catch (NullPointerException npex)
	            	{
	            		csv.write("null" + ",");
	            	}
	            }
	            csv.write("\n");
	        }

	        csv.close();
	        return true;
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
