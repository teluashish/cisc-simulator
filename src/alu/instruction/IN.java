package alu.instruction;

import cpu.Registers;
import memory.MCU;
import util.Const;
import util.MachineFaultException;
import util.StringUtil;

/**
 * 
 * IN r, devid</br>
 * Input Character To Register from Device
 * 
 * @author Liang
 *
 */
public class IN extends AbstractInstruction {

    int num;
    int devId;

    @Override
    public void execute(String instruction, Registers registers, MCU mcu) throws MachineFaultException {
        this.num = StringUtil.binaryToDecimal(instruction.substring(6, 8));
        this.devId = StringUtil.binaryToDecimal(instruction.substring(11, 16));

        if (this.devId == Const.DevId.KEYBOARD.getValue()) {
            String buffer = mcu.getKeyboardBuffer();

            if (buffer != null && buffer.length() > 0) {

                int val = buffer.charAt(0);
                registers.setRnByNum(this.num, val);
                mcu.setKeyboardBuffer(buffer.substring(1, buffer.length()));

            } else {
                registers.setRnByNum(this.num, 0);
            }

        }
        if (this.devId == Const.DevId.CARD.getValue()) {
            String buffer = mcu.getCardBuffer();
            
            if (buffer != null && buffer.length() > 0) {
                
                int val = buffer.charAt(0);
                registers.setRnByNum(this.num, val);
                mcu.setCardBuffer(buffer.substring(1, buffer.length()));
                
            } else {
                registers.setRnByNum(this.num, 0);
            }
        }
        registers.increasePCByOne();
    }

    @Override
    public String getExecuteMessage() {
        return "IN " + this.num + ", " + this.devId;
    }

}
