package org.usfirst.frc.team5026.robot;

import edu.wpi.first.wpilibj.I2C;

public class ColorSensorI2C {
	I2C i2cDevice;
	
	final int COLOR_BYTE_LENGTH = 2;
	final int START_ADDRESS = 0x16; // 16 in Hexadecimal
	/*
	 * The follwing constants taken from https://github.com/adafruit/Adafruit_TCS34725/blob/master/Adafruit_TCS34725.h
	 */
	final byte COMMAND_BIT = (byte) 0x80;
	// All of the following bytes are offset by the COMMAND_BIT
	final byte ADDRESS = 0x29;
	final byte ID = 0x12;
	final byte STATUS = 0x13;
	final byte ENABLE = 0x00; // Enable register
	final byte ENABLE_PON = 0x01;
	final byte ENABLE_RGBC = 0x02; // Write 1 to enable, 0 to disable
	final byte INTEGRATION_TIME = 0x01; // Integration time register
	final byte WAIT_TIME = 0x03; // Wait time register
	final byte CONTROL = 0x0F; // Control register
	final byte C_LOW = 0x14;
	final byte C_HIGH = 0x15;
	final byte R_LOW = 0x16;
	final byte R_HIGH = 0x17;
	final byte G_LOW = 0x18;
	final byte G_HIGH = 0x19;
	final byte B_LOW = 0x1A;
	final byte B_HIGH = 0x1B;
	
	public ColorSensorI2C(I2C.Port port, int deviceAddr) {
		i2cDevice = new I2C(port, deviceAddr);
		enable();
		setup();
	}
	public void write8(byte b, int value) {
		i2cDevice.write(COMMAND_BIT | b, value & 0xFF);
	}
	public byte read8(byte b) {
//		i2cDevice.write(COMMAND_BIT, b);
		
		byte[] buffer = new byte[1];
		i2cDevice.read(COMMAND_BIT | b, 1, buffer);
		System.out.println(Integer.toHexString(COMMAND_BIT | b));
		return buffer[0];
	}
	public int read16(byte lb, byte hb) {
		byte low, high = 0;
		low = read8(lb);
		high = read8(hb); // reads next byte?
		short temp = (short) high;
		temp <<= 8;
		temp |= low;
		return temp;
	}
	public int convert16(byte b, byte b2) {
		return ((b & 0xFF) * 256) + (b2 & 0xFF);
	}
	public void enable() {
		write8(ENABLE, ENABLE_PON);
		write8(ENABLE, ENABLE_PON | ENABLE_RGBC); // Enables with just RGBC, no time enabled
	}
	public void disable() {
		byte reg = (byte) read8(ENABLE);
		write8(ENABLE, reg & ~(ENABLE_PON | ENABLE_RGBC));
	}
	public void setup() {
		write8(INTEGRATION_TIME, 0x00); // Sets to default: 2.4ms
		write8(WAIT_TIME, 0xFF); // Sets to no wait time
		write8(CONTROL, 0x00); // 1x control
	}
	public int[] getRGBC() {
		int[] out = new int[4];
//		byte[] buf = new byte[50];
//		
//		i2cDevice.read(0x08, 50, buf);
//		for (int i = 0; i < buf.length; i++) {
//			SmartDashboard.putString(Integer.toHexString(0x88+i),Integer.toBinaryString(buf[i]));
//			SmartDashboard.putString(Integer.toHexString(0x88+i)+" as uint", Integer.toUnsignedString(buf[i]));
//		}
		
		byte[] buffer = new byte[8];
		i2cDevice.read(COMMAND_BIT | C_LOW, 8, buffer);
		out[0] = convert16(buffer[3], buffer[2]); // Red
		out[1] = convert16(buffer[5], buffer[4]); // Green
		out[2] = convert16(buffer[7], buffer[6]); // Blue
		out[3] = convert16(buffer[1], buffer[0]); // Clear data
		return out;
	}
	public int getRed() {
		return getRGBC()[0];
	}
	public int getGreen() {
		return getRGBC()[1];
	}
	public int getBlue() {
		return getRGBC()[2];
	}
	public int getClearData() {
		return getRGBC()[3];
	}
	public double getLuminosity() {
		// MAGIC formula (from technical specs, as well as prev. GitHub link)
		return -0.32466 * getRed() + 1.57837 * getGreen() - 0.73191 * getBlue();
	}
	public boolean exists() {
		// Not very useful, always true
		return !i2cDevice.addressOnly();
	}
//	public int getR() {
//		return read16(R_LOW, R_HIGH);
//	}
	public void printStats() {
		System.out.println("ADDR (0x29): "+read8(ADDRESS));
		System.out.println("COMMAND (0x80): "+read8(this.COMMAND_BIT));
		System.out.println("ENABLED (0x00): "+read8(this.ENABLE));
		System.out.println("ID (0x12): "+read8(this.ID));
		System.out.println("STATUS (0x13): "+read8(this.STATUS));
		System.out.println("IS RGBC VALID? (0x13, bit0): "+(read8(this.STATUS) & 0b00000001));
		System.out.println("IS INTERRUPTED? (0x13, bit4): "+(read8(this.STATUS) & 0b00010000));
		System.out.println("RED LOW (0x16): "+read8(this.R_LOW));
		System.out.println("RED HIGH (0x17): "+read8(this.R_HIGH));
		System.out.println("RED VALUE: "+read16(this.R_LOW,this.R_HIGH));
	}
//	public int getRed() {
////		ByteBuffer buffer = ByteBuffer.allocate(COLOR_BYTE_LENGTH);
//		byte[] buffer = new byte[COLOR_BYTE_LENGTH];
//		System.out.println("Before read:\n==================\n");
//		for (byte b : buffer) {
//			System.out.println(b);
//		}
//		System.out.println(i2cDevice.read(START_ADDRESS, COLOR_BYTE_LENGTH, buffer));
//		System.out.println("Post read:\n==================\n");
//		for (byte b : buffer) {
//			System.out.println(b);
//		}
//		for (byte b : buffer) {
//			System.out.println("Color Num: "+(int)b);
//		}
//		return 0;
//	}
}
