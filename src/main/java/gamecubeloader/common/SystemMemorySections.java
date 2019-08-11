package gamecubeloader.common;

import ghidra.app.util.MemoryBlockUtil;
import ghidra.program.model.listing.Program;

public final class SystemMemorySections {
	public static void Create(Program program, MemoryBlockUtil memblockUtil) {
		var addressSpace = program.getAddressFactory().getDefaultAddressSpace();
		
		// Create globals section first
		memblockUtil.createUninitializedBlock(false, "OS Globals", addressSpace.getAddress(0x80000000), 0x3100, "Operating System Globals", null, true, true, false);
		
		// Now create hardware registers
		memblockUtil.createUninitializedBlock(false, "CP", addressSpace.getAddress(0xCC000000), 0x80, "Command Processor Register", null, true, true, false);
		memblockUtil.createUninitializedBlock(false, "PE", addressSpace.getAddress(0xCC001000), 0x100, "Pixel Engine Register", null, true, true, false);
		memblockUtil.createUninitializedBlock(false, "VI", addressSpace.getAddress(0xCC002000), 0x100, "Video Interface Register", null, true, true, false);
		memblockUtil.createUninitializedBlock(false, "PI", addressSpace.getAddress(0xCC003000), 0x100, "Processor Interface Register", null, true, true, false);
		memblockUtil.createUninitializedBlock(false, "MI", addressSpace.getAddress(0xCC004000), 0x80, "Memory Interface Register", null, true, true, false);
		memblockUtil.createUninitializedBlock(false, "DSP", addressSpace.getAddress(0xCC005000), 0x200, "Digital Signal Processor Register", null, true, true, false);
		memblockUtil.createUninitializedBlock(false, "DI", addressSpace.getAddress(0xCC006000), 0x40, "DVD Interface Reigster", null, true, true, false);
		memblockUtil.createUninitializedBlock(false, "SI", addressSpace.getAddress(0xCC006400), 0x100, "Serial Interface Reigster", null, true, true, false);
		memblockUtil.createUninitializedBlock(false, "EXI", addressSpace.getAddress(0xCC006800), 0x40, "External Interface Reigster", null, true, true, false);
		memblockUtil.createUninitializedBlock(false, "AI", addressSpace.getAddress(0xCC006C00), 0x40, "Audio Interface Reigster", null, true, true, false);
		memblockUtil.createUninitializedBlock(false, "GXFIFO", addressSpace.getAddress(0xCC008000), 0x4, "Graphics FIFO Reigster", null, true, true, false);
	}
}
