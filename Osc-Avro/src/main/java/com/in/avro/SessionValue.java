/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.in.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class SessionValue extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5014273818432320771L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SessionValue\",\"namespace\":\"com.in.avro\",\"fields\":[{\"name\":\"sessionStatus\",\"type\":\"boolean\",\"default\":false}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<SessionValue> ENCODER =
      new BinaryMessageEncoder<SessionValue>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<SessionValue> DECODER =
      new BinaryMessageDecoder<SessionValue>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<SessionValue> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<SessionValue> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<SessionValue> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<SessionValue>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this SessionValue to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a SessionValue from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a SessionValue instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static SessionValue fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private boolean sessionStatus;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public SessionValue() {}

  /**
   * All-args constructor.
   * @param sessionStatus The new value for sessionStatus
   */
  public SessionValue(java.lang.Boolean sessionStatus) {
    this.sessionStatus = sessionStatus;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return sessionStatus;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: sessionStatus = (java.lang.Boolean)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'sessionStatus' field.
   * @return The value of the 'sessionStatus' field.
   */
  public boolean getSessionStatus() {
    return sessionStatus;
  }


  /**
   * Sets the value of the 'sessionStatus' field.
   * @param value the value to set.
   */
  public void setSessionStatus(boolean value) {
    this.sessionStatus = value;
  }

  /**
   * Creates a new SessionValue RecordBuilder.
   * @return A new SessionValue RecordBuilder
   */
  public static com.in.avro.SessionValue.Builder newBuilder() {
    return new com.in.avro.SessionValue.Builder();
  }

  /**
   * Creates a new SessionValue RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new SessionValue RecordBuilder
   */
  public static com.in.avro.SessionValue.Builder newBuilder(com.in.avro.SessionValue.Builder other) {
    if (other == null) {
      return new com.in.avro.SessionValue.Builder();
    } else {
      return new com.in.avro.SessionValue.Builder(other);
    }
  }

  /**
   * Creates a new SessionValue RecordBuilder by copying an existing SessionValue instance.
   * @param other The existing instance to copy.
   * @return A new SessionValue RecordBuilder
   */
  public static com.in.avro.SessionValue.Builder newBuilder(com.in.avro.SessionValue other) {
    if (other == null) {
      return new com.in.avro.SessionValue.Builder();
    } else {
      return new com.in.avro.SessionValue.Builder(other);
    }
  }

  /**
   * RecordBuilder for SessionValue instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SessionValue>
    implements org.apache.avro.data.RecordBuilder<SessionValue> {

    private boolean sessionStatus;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.in.avro.SessionValue.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.sessionStatus)) {
        this.sessionStatus = data().deepCopy(fields()[0].schema(), other.sessionStatus);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
    }

    /**
     * Creates a Builder by copying an existing SessionValue instance
     * @param other The existing instance to copy.
     */
    private Builder(com.in.avro.SessionValue other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.sessionStatus)) {
        this.sessionStatus = data().deepCopy(fields()[0].schema(), other.sessionStatus);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'sessionStatus' field.
      * @return The value.
      */
    public boolean getSessionStatus() {
      return sessionStatus;
    }


    /**
      * Sets the value of the 'sessionStatus' field.
      * @param value The value of 'sessionStatus'.
      * @return This builder.
      */
    public com.in.avro.SessionValue.Builder setSessionStatus(boolean value) {
      validate(fields()[0], value);
      this.sessionStatus = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'sessionStatus' field has been set.
      * @return True if the 'sessionStatus' field has been set, false otherwise.
      */
    public boolean hasSessionStatus() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'sessionStatus' field.
      * @return This builder.
      */
    public com.in.avro.SessionValue.Builder clearSessionStatus() {
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public SessionValue build() {
      try {
        SessionValue record = new SessionValue();
        record.sessionStatus = fieldSetFlags()[0] ? this.sessionStatus : (java.lang.Boolean) defaultValue(fields()[0]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<SessionValue>
    WRITER$ = (org.apache.avro.io.DatumWriter<SessionValue>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<SessionValue>
    READER$ = (org.apache.avro.io.DatumReader<SessionValue>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeBoolean(this.sessionStatus);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.sessionStatus = in.readBoolean();

    } else {
      for (int i = 0; i < 1; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.sessionStatus = in.readBoolean();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









