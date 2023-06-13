const TransferCreditInput = ({ onChangeTransferCredits }) => (
    
    <div className="form-group">
        <label>
            Total Transfer Credits:
            <input type="number"
                defaultValue="0"
                onChange={onChangeTransferCredits}
            />
        </label>
    </div>
);

export default TransferCreditInput;

