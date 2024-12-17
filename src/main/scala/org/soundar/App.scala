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
      .vaultUrl("https://key-vault-name.vault.azure.net/")
      .credential(cred)
      .buildClient()

    val result = keyVaultClient.getSecret("some-secret-name-in-vault")
    println(result.getValue())
  }

}
