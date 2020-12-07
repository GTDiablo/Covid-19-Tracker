dependencies {
    // Required -- JUnit 4 framework
    testImplementation 'junit:junit:4.12'
    // Optional -- Robolectric environment
    testImplementation 'androidx.test:core:1.0.0'
    // Optional -- Mockito framework
    testImplementation 'org.mockito:mockito-core:1.10.19'
}

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class EmailValidatorTest {
    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertThat(EmailValidator.isValidEmail("name@email.com")).isTrue()
    }
}

android {
    // ...
    testOptions {
        unitTests.includeAndroidResources = true
    }
}

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Test

// Eze a keresési stringet szimulálja 
private const val FAKE_STRING = "HUNGARY"

class UnitTestSample {
    val context = ApplicationProvider.getApplicationContext<Context>()

    @Test fun readStringFromContext_LocalizedString() {
        // Given a Context object retrieved from Robolectric...
        val myObjectUnderTest = ClassUnderTest(context)

        // ...when the string is returned from the object under test...
        val result: String = myObjectUnderTest.getHelloWorldString()

        // ...then the result should be the expected one.
        assertThat(result).isEqualTo(FAKE_STRING)
    }
}

import android.content.Context
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

private const val FAKE_STRING = "HELLO WORLD"

@RunWith(MockitoJUnitRunner::class)
class UnitTestSample {

    @Mock
    private lateinit var mockContext: Context

    @Test
    fun readStringFromContext_LocalizedString() {
        // Given a mocked Context injected into the object under test...
        `when`(mockContext.getString(R.string.hello_word))
                .thenReturn(FAKE_STRING)
        val myObjectUnderTest = ClassUnderTest(mockContext)

        // ...when the string is returned from the object under test...
        val result: String = myObjectUnderTest.getHelloWorldString()

        // ...then the result should be the expected one.
        assertThat(result, `is`(FAKE_STRING))
    }
}

android {
  ...
  testOptions {
    unitTests.returnDefaultValues = true
  }
}
