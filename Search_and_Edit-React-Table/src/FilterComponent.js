import { useState, useEffect } from "react";

const FilterComponent = (initialData, transferCredits) => {
  const [tableData, setTableData] = useState(initialData);

  const handleSave = (index, editedData) => {
    setTableData((prevData) =>
      prevData.map((rowData, i) => (i === index ? editedData : rowData))
    );
  };

  useEffect(() => {
    let results = initialData;
    if (transferCredits >= 0 && transferCredits < 40) {
      results = initialData.slice(0, 3);
    } else if (transferCredits >= 40 && transferCredits < 70) {
      results = initialData.slice(0, 2);
    } else if (transferCredits > 70) {
      results = initialData.slice(0, 1);
    }

    setTableData(results);
  }, [initialData, transferCredits]);

  return { tableData, handleSave };
};

export default FilterComponent;
