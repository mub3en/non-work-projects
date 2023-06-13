import React from "react";
import Table from 'react-bootstrap/Table';
import 'bootstrap/dist/css/bootstrap.min.css';
import TableHeader from './TableHeader'
import TableRow from './TableRow'

const TableStructure = ({ data, onSave }) => (
  <div>
    < Table striped bordered hover >
      <TableHeader />
      <tbody style={{ textAllign: "center" }}>
        {data.map((rowData, index) => (
          <TableRow key={index} data={rowData} onSave={(editedData) => onSave(index, editedData)} />
        ))}
      </tbody>
    </Table>
  </div>
);


export default TableStructure;
