package org.soundar

/**
 * @author ${user.name}
 */

import com.azure.identity.DefaultAzureCredentialBuilder
import com.azure.security.keyvault.secrets.SecretClientBuilder

object App {
  
  def main(args : Array[String]): Unit = {
    val cred = new DefaultAzureCredentialBuilder().build()

    val keyVaultClient = new SecretClientBuilder()
      .vaultUrl(args(0))
      .credential(cred)
      .buildClient()

    val result = keyVaultClient.getSecret(args(1))
    println(result.getValue())
  }

}
