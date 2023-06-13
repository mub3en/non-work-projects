import React, { useState } from "react";
import EditRow from "./EditRow";

const TableRow = ({ data, onSave }) => {
  const [isEditing, setIsEditing] = useState(false);
  const [editedData, setEditedData] = useState(data);

  const handleEdit = (event) => {
    const { name, value } = event.target;
    setEditedData({ ...editedData, [name]: value });
  };

  const handleSave = () => {
    setIsEditing(false);
    onSave(editedData);
  };

  const handleCancel = () => {
    setIsEditing(false);
  };

  return (
    <>
      <tr>
        <td>{data.id}</td>
        <td>{data.description}</td>
        <td>{data.semester}</td>
        <td>{data.prefix}</td>
        <td>{data.number}</td>
        <td>{data.grade}</td>
        <td>
          <button className="btn btn-warning btn-sm" 
               data-bs-toggle="modal" 
            onClick={() => {
              setEditedData(data);
              setIsEditing(true);
            }}>
            Edit
          </button>
        </td>
      </tr>
      {isEditing && (
        <EditRow
          data={editedData}
          onSave={handleSave}
          onCancel={handleCancel}
          onEdit={handleEdit}
        />
      )}
    </>
  );
};

export default TableRow;
