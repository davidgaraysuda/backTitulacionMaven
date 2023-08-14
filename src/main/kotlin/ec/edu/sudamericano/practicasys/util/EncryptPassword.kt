//package ec.edu.sudamericano.practicasys.util
//
//class EncryptPassword {
//
//    fun sha1(input: String) = hashString("SHA-1", input)
//    fun md5(input: String) = hashString("MD5", input)
//
//    private fun hashString(type: String, input: String): String {
//        val bytes = MessageDigest
//                .getInstance(type)
//                .digest(input.toByteArray())
//        return DatatypeConverter.printHexBinary(bytes).toUpperCase()
//    }
//}