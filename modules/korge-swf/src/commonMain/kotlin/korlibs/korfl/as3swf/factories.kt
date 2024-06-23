package korlibs.korfl.as3swf

interface ISWFTagFactory {
	fun create(type: Int): ITag
}

object SWFActionFactory {
	fun create(code: Int, length: Int, pos: Int): IAction = when (code) {
		0x04 -> ActionNextFrame(code, length, pos)
		0x05 -> ActionPreviousFrame(code, length, pos)
		0x06 -> ActionPlay(code, length, pos)
		0x07 -> ActionStop(code, length, pos)
		0x08 -> ActionToggleQuality(code, length, pos)
		0x09 -> ActionStopSounds(code, length, pos)
		0x0a -> ActionAdd(code, length, pos)
		0x0b -> ActionSubtract(code, length, pos)
		0x0c -> ActionMultiply(code, length, pos)
		0x0d -> ActionDivide(code, length, pos)
		0x0e -> ActionEquals(code, length, pos)
		0x0f -> ActionLess(code, length, pos)
		0x10 -> ActionAnd(code, length, pos)
		0x11 -> ActionOr(code, length, pos)
		0x12 -> ActionNot(code, length, pos)
		0x13 -> ActionStringEquals(code, length, pos)
		0x14 -> ActionStringLength(code, length, pos)
		0x15 -> ActionStringExtract(code, length, pos)
		0x17 -> ActionPop(code, length, pos)
		0x18 -> ActionToInteger(code, length, pos)
		0x1c -> ActionGetVariable(code, length, pos)
		0x1d -> ActionSetVariable(code, length, pos)
		0x20 -> ActionSetTarget2(code, length, pos)
		0x21 -> ActionStringAdd(code, length, pos)
		0x22 -> ActionGetProperty(code, length, pos)
		0x23 -> ActionSetProperty(code, length, pos)
		0x24 -> ActionCloneSprite(code, length, pos)
		0x25 -> ActionRemoveSprite(code, length, pos)
		0x26 -> ActionTrace(code, length, pos)
		0x27 -> ActionStartDrag(code, length, pos)
		0x28 -> ActionEndDrag(code, length, pos)
		0x29 -> ActionStringLess(code, length, pos)
		0x2a -> ActionThrow(code, length, pos)
		0x2b -> ActionCastOp(code, length, pos)
		0x2c -> ActionImplementsOp(code, length, pos)
		0x30 -> ActionRandomNumber(code, length, pos)
		0x31 -> ActionMBStringLength(code, length, pos)
		0x32 -> ActionCharToAscii(code, length, pos)
		0x33 -> ActionAsciiToChar(code, length, pos)
		0x34 -> ActionGetTime(code, length, pos)
		0x35 -> ActionMBStringExtract(code, length, pos)
		0x36 -> ActionMBCharToAscii(code, length, pos)
		0x37 -> ActionMBAsciiToChar(code, length, pos)
		0x3a -> ActionDelete(code, length, pos)
		0x3b -> ActionDelete2(code, length, pos)
		0x3c -> ActionDefineLocal(code, length, pos)
		0x3d -> ActionCallFunction(code, length, pos)
		0x3e -> ActionReturn(code, length, pos)
		0x3f -> ActionModulo(code, length, pos)
		0x40 -> ActionNewObject(code, length, pos)
		0x41 -> ActionDefineLocal2(code, length, pos)
		0x42 -> ActionInitArray(code, length, pos)
		0x43 -> ActionInitObject(code, length, pos)
		0x44 -> ActionTypeOf(code, length, pos)
		0x45 -> ActionTargetPath(code, length, pos)
		0x46 -> ActionEnumerate(code, length, pos)
		0x47 -> ActionAdd2(code, length, pos)
		0x48 -> ActionLess2(code, length, pos)
		0x49 -> ActionEquals2(code, length, pos)
		0x4a -> ActionToNumber(code, length, pos)
		0x4b -> ActionToString(code, length, pos)
		0x4c -> ActionPushDuplicate(code, length, pos)
		0x4d -> ActionStackSwap(code, length, pos)
		0x4e -> ActionGetMember(code, length, pos)
		0x4f -> ActionSetMember(code, length, pos)
		0x50 -> ActionIncrement(code, length, pos)
		0x51 -> ActionDecrement(code, length, pos)
		0x52 -> ActionCallMethod(code, length, pos)
		0x53 -> ActionNewMethod(code, length, pos)
		0x54 -> ActionInstanceOf(code, length, pos)
		0x55 -> ActionEnumerate2(code, length, pos)
		0x60 -> ActionBitAnd(code, length, pos)
		0x61 -> ActionBitOr(code, length, pos)
		0x62 -> ActionBitXor(code, length, pos)
		0x63 -> ActionBitLShift(code, length, pos)
		0x64 -> ActionBitRShift(code, length, pos)
		0x65 -> ActionBitURShift(code, length, pos)
		0x66 -> ActionStrictEquals(code, length, pos)
		0x67 -> ActionGreater(code, length, pos)
		0x68 -> ActionStringGreater(code, length, pos)
		0x69 -> ActionExtends(code, length, pos)
		0x81 -> ActionGotoFrame(code, length, pos)
		0x83 -> ActionGetURL(code, length, pos)
		0x87 -> ActionStoreRegister(code, length, pos)
		0x88 -> ActionConstantPool(code, length, pos)
		0x8a -> ActionWaitForFrame(code, length, pos)
		0x8b -> ActionSetTarget(code, length, pos)
		0x8c -> ActionGotoLabel(code, length, pos)
		0x8d -> ActionWaitForFrame2(code, length, pos)
		0x8e -> ActionDefineFunction2(code, length, pos)
		0x8f -> ActionTry(code, length, pos)
		0x94 -> ActionWith(code, length, pos)
		0x96 -> ActionPush(code, length, pos)
		0x99 -> ActionJump(code, length, pos)
		0x9a -> ActionGetURL2(code, length, pos)
		0x9b -> ActionDefineFunction(code, length, pos)
		0x9d -> ActionIf(code, length, pos)
		0x9e -> ActionCall(code, length, pos)
		0x9f -> ActionGotoFrame2(code, length, pos)
		else -> ActionUnknown(code, length, pos)
	}
}

object SWFFilterFactory {
	fun create(id: Int): IFilter = when (id) {
		0 -> FilterDropShadow(id)
		1 -> FilterBlur(id)
		2 -> FilterGlow(id)
		3 -> FilterBevel(id)
		4 -> FilterGradientGlow(id)
		5 -> FilterConvolution(id)
		6 -> FilterColorMatrix(id)
		7 -> FilterGradientBevel(id)
		else -> error("Unknown filter ID: $id")
	}
}

open class SWFTagFactory : ISWFTagFactory {
	override fun create(type: Int): ITag = when (type) {
		0 -> TagEnd()
		1 -> TagShowFrame()
		2 -> TagDefineShape()
		4 -> TagPlaceObject()
		5 -> TagRemoveObject()
		6 -> TagDefineBits()
		7 -> TagDefineButton()
		8 -> TagJPEGTables()
		9 -> TagSetBackgroundColor()
		10 -> TagDefineFont()
		11 -> TagDefineText()
		12 -> TagDoAction()
		13 -> TagDefineFontInfo()
		14 -> TagDefineSound()
		15 -> TagStartSound()
		17 -> TagDefineButtonSound()
		18 -> TagSoundStreamHead()
		19 -> TagSoundStreamBlock()
		20 -> TagDefineBitsLossless()
		21 -> TagDefineBitsJPEG2()
		22 -> TagDefineShape2()
		23 -> TagDefineButtonCxform()
		24 -> TagProtect()
		25 -> TagPathsArePostScript()
		26 -> TagPlaceObject2()
		28 -> TagRemoveObject2()
		32 -> TagDefineShape3()
		33 -> TagDefineText2()
		34 -> TagDefineButton2()
		35 -> TagDefineBitsJPEG3()
		36 -> TagDefineBitsLossless2()
		37 -> TagDefineEditText()
		39 -> TagDefineSprite()
		40 -> TagNameCharacter()
		41 -> TagProductInfo()
		43 -> TagFrameLabel()
		45 -> TagSoundStreamHead2()
		46 -> TagDefineMorphShape()
		48 -> TagDefineFont2()
		56 -> TagExportAssets()
		57 -> TagImportAssets()
		58 -> TagEnableDebugger()
		59 -> TagDoInitAction()
		60 -> TagDefineVideoStream()
		61 -> TagVideoFrame()
		62 -> TagDefineFontInfo2()
		63 -> TagDebugID()
		64 -> TagEnableDebugger2()
		65 -> TagScriptLimits()
		66 -> TagSetTabIndex()
		69 -> TagFileAttributes()
		70 -> TagPlaceObject3()
		71 -> TagImportAssets2()
		72 -> TagDoABCDeprecated()
		73 -> TagDefineFontAlignZones()
		74 -> TagCSMTextSettings()
		75 -> TagDefineFont3()
		76 -> TagSymbolClass()
		77 -> TagMetadata()
		78 -> TagDefineScalingGrid()
		82 -> TagDoABC()
		83 -> TagDefineShape4()
		84 -> TagDefineMorphShape2()
		86 -> TagDefineSceneAndFrameLabelData()
		87 -> TagDefineBinaryData()
		88 -> TagDefineFontName()
		89 -> TagStartSound2()
		90 -> TagDefineBitsJPEG4()
		91 -> TagDefineFont4()
		93 -> TagEnableTelemetry()
		94 -> TagPlaceObject4()
		253 -> TagSWFEncryptActions()
		255 -> TagSWFEncryptSignature()
		else -> TagUnknown(type)
	}
}
