package com.azhya.models;

import java.time.LocalDateTime;

public class BankTransaction {
	private int txId;
	private LocalDateTime txTimestamp;
	private double txAmount;
	private int txAccountId; //this is how you can handle dealing w/authors and resolvers in your project; can use an Object instead int here
	public BankTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankTransaction(int txId, LocalDateTime txTimestamp, double txAmount, int txAccountId) {
		super();
		this.txId = txId;
		this.txTimestamp = txTimestamp;
		this.txAmount = txAmount;
		this.txAccountId = txAccountId;
	}
	public BankTransaction(LocalDateTime txTimestamp, double txAmount, int txAccountId) {
		super();
		this.txTimestamp = txTimestamp;
		this.txAmount = txAmount;
		this.txAccountId = txAccountId;
	}
	public int getTxId() {
		return txId;
	}
	public void setTxId(int txId) {
		this.txId = txId;
	}
	public LocalDateTime getTxTimestamp() {
		return txTimestamp;
	}
	public void setTxTimestamp(LocalDateTime txTimestamp) {
		this.txTimestamp = txTimestamp;
	}
	public double getTxAmount() {
		return txAmount;
	}
	public void setTxAmount(double txAmount) {
		this.txAmount = txAmount;
	}
	public int getTxAccountId() {
		return txAccountId;
	}
	public void setTxAccountId(int txAccountId) {
		this.txAccountId = txAccountId;
	}
	@Override
	public String toString() {
		return "BankTransaction [txId=" + txId + ", txTimestamp=" + txTimestamp + ", txAmount=" + txAmount
				+ ", txAccountId=" + txAccountId + "]";
	}
}
