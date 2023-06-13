import React from "react";

const EditRow = ({ data, onEdit, onSave, onCancel }) => {
  return (
    <div className="modal fade" tabIndex="-1" aria-hidden="true">
      <div className="modal-dialog">
        <div className="modal-body">
          <tr>
            <td>{data.id}</td>
            <td>
              <input
                type="text"
                name="description"
                value={data.description}
                onChange={onEdit}
              />
            </td>
            <td>
              <input
                type="text"
                name="semester"
                value={data.semester}
                onChange={onEdit}
              />
            </td>
            <td>
              <input
                type="text"
                name="prefix"
                value={data.prefix}
                onChange={onEdit}
              />
            </td>
            <td>
              <input
                type="text"
                name="number"
                value={data.number}
                onChange={onEdit}
              />
            </td>
            <td>
              <input
                type="text"
                name="grade"
                value={data.grade}
                onChange={onEdit}
              />
            </td>
            <td>
              <button className="btn btn-success btn-sm" onClick={onSave}>
                Save
              </button>
              <button className="btn btn-dark btn-sm" onClick={onCancel}>
                Cancel
              </button>
            </td>
          </tr>
        </div>
      </div>
    </div>
  );
};

export default EditRow;
