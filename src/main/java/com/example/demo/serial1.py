#!/usr/bin/env python3
import serial
import time
if __name__ == '__main__':
    ser = serial.Serial('/dev/ttyACM0', 9600, timeout=1)
    ser.flush()
    ser.write(b"humidity2")
    time.sleep(1)
    line = ser.readline().decode('utf-8').rstrip()
    print(line)
